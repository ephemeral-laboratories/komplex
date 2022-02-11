Komplex
=======

A simple, multiplatform, Kotlin-friendly complex math library.

Defines a `Complex` class with the usual operators you
would expect to be able to use with numbers.

Also defines a collection of functions, aiming for parity 
with the functions supported by `kotlin.math` for doubles,
but for complex numbers.


Using in your project
---------------------

If your project only targets the JVM:

```kotlin
dependencies {
    implementation("garden.ephemeral.math:komplex-jvm:$komplexVersion")
}
```

For JS, you can use the `komplex-js` artifact instead, and similarly
for other targets.

For a Kotlin/Multiplatform common build, use the `komplex` artifact instead.


Quick API summary
-----------------

Creating a complex number:

```kotlin
val z = Complex(1.0, 2.0)
```

Some people may prefer this alternative:

```kotlin
val z = 1 + 2.i
```

There is a slight overhead with this approach, as it creates more
throwaway objects to do its job.

Most functions available in `kotlin.math` have identically-named
counterparts in `garden.ephemeral.math.complex` - import them as-needed
or via a wildcard import.

```kotlin
val zSquared = z.pow(2.0)
val sinZ = sin(z)
```

If you find any useful functions missing, [open a ticket][1] -
they are most likely fairly easy to add. But this is Kotlin, so you
can also declare extension functions and use those while you wait.

API docs pending


Building
--------

Currently, this build does not bootstrap an appropriate JDK for itself,
so make sure the `JAVA_HOME` environment variable points to a JDK 11
installation. 

Then run Gradle:

```shell
./gradlew publish
```

If on Windows:

```shell
.\gradlew.bat publish
```

[1]: https://github.com/ephemeral-laboratories/komplex/issues
