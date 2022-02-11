import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.dokka") version "1.6.10"
    `maven-publish`
    signing
}

group = "garden.ephemeral.math"
version = libs.versions.komplex.get()
description = "Kotlin multiplatform complex math library"

repositories {
    mavenCentral()
}

val nativeTargets = arrayOf(
    "linuxX64",
    "macosX64", "macosArm64",
    "iosArm32", "iosArm64", "iosX64", "iosSimulatorArm64",
    "tvosArm64", "tvosX64", "tvosSimulatorArm64",
    "watchosArm32", "watchosArm64", "watchosX86", "watchosX64", "watchosSimulatorArm64",
    // TODO: No assertk on mingwX64 yet: https://github.com/willowtreeapps/assertk/issues/406
    // "mingwX64",
)

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js(BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }

    for (target in nativeTargets) {
        targets.add(presets.getByName(target).createTarget(target))
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.assertk)
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting

        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }

        for (sourceSet in nativeTargets) {
            getByName("${sourceSet}Main") {
                dependsOn(nativeMain)
            }
            getByName("${sourceSet}Test") {
                dependsOn(nativeTest)
            }
        }
    }
}

val isReleaseVersion by project.extra {
    // Relies on a command-line-provided system property, to mitigate the risk of
    // accidentally treating arbitrary main branch commits as a release
    // XXX: Could pass the actual tag and check that it and the version match?
    val isRealRelease = project.findProperty("realRelease") == "true"
    val isSnapshotVersion = project.version.toString().endsWith("-SNAPSHOT")
    isRealRelease && !isSnapshotVersion
}

tasks {
    val dokkaHtml by getting(DokkaTask::class)

    val javadocJar by registering(Jar::class) {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.outputDirectory)
    }
}

publishing {
    publications.withType<MavenPublication>().configureEach {
        // TODO: Figure out how much we need to pass all Sonatype's checks
//        artifact(tasks.named("sourcesJar"))
        artifact(tasks.named("javadocJar"))

        pom {
            val projectGitUrl = "https://github.com/ephemeral-laboratories/komplex"
            name.set(project.name)
            description.set(project.description)
            url.set(projectGitUrl)
            inceptionYear.set("2022")
            licenses {
                license {
                    name.set("MIT")
                    url.set("$projectGitUrl/blob/main/COPYING.txt")
                }
            }
            developers {
                developer {
                    id.set("hakanai")
                    name.set("Hakanai")
                    email.set("hakanai@ephemeral.garden")
                    url.set("https://linktr.ee/hakanai")
                }
            }
            issueManagement {
                system.set("GitHub")
                url.set("$projectGitUrl/issues")
            }
            scm {
                url.set(projectGitUrl)
                connection.set("scm:git:$projectGitUrl")
                developerConnection.set("scm:git:$projectGitUrl")
            }
        }
    }

    signing.sign(publications)

    repositories.maven {
        url = if (isReleaseVersion) {
            uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
        } else {
            uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
        }

        val ossrhUsername = findProperty("ossrhUsername") as? String ?: System.getenv("OSSRH_USERNAME")
        val ossrhPassword = findProperty("ossrhPassword") as? String ?: System.getenv("OSSRH_PASSWORD")
        if (ossrhUsername != null && ossrhPassword != null) {
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}
