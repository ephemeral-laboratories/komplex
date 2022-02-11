Releasing this Software
=======================

Semi-automatic process
----------------------

1. Edit the version number in `libs.versions.toml` to remove `-SNAPSHOT`,
   e.g., if it was `"1.2.3-SNAPSHOT"`, then it becomes `"1.2.3"`.
2. Commit that change.
3. Tag that commit with `vMAJOR.MINOR.PATCH`.
4. Edit the version number in `libs.versions.toml` again, bumping to the
   next snapshot version, e.g. if it was `"1.2.3"` then it becomes
   `"1.2.4-SNAPSHOT"`.
5. Commit that change.
6. Push both those commits, and the tag.
7. Wait for GitHub Actions to build and publish the release from
   the tag.
8. Log into [Sonatype][2], go into Staging Repositories and check
   that what's there is usable.
9. Select all repos, click Close, wait and hope that all checks pass.
10. Select all repos, click Release, wait.
11. Double-check if you want that everything has ended up in
    [releases][3].

XXX: Automating this Sonatype stuff would be the next nice thing to do.
    Opening a single repository before any of the publishing tasks run
    would be a really nice idea as well, to speed things up.

Manual process
--------------

The same steps as above, but in place of GitHub Actions:

1. Ensure that a GPG signing key is present and has been uploaded to
   the key server. Note that Gradle only supports reading keys from
   the legacy `secring.gpg` file, which since GnuPG 2.1 is no longer
   used ([Gradle ticket about this issue][1]).
   The workaround for now is to create the legacy file manually:
   ```shell
   gpg --export-secret-keys > %UserProfile%\.gnupg\secring.gpg
   ```
   You'll have to run this to recreate the file every time you change
   or add any private keys.

2. Put the following into `~/.gradle/gradle.properties`:

    ```shell
    ossrhUsername=[OSSRH username]
    ossrhPassword=[OSSRH password]
    
    signing.keyId=[last 8 digits of GPG key ID]
    signing.password=[GPG key password]
    signing.secretKeyRingFile=/path/to/.gnupg/secring.gpg
    ```

   (Alternatively you can pass each property with `-Pname=value`
    on the command-line, but since this contains passwords, that
    is not secure!)

3. Run Gradle:

    ```shell
    ./gradlew publish
    ```
   
   Or if you're on Windows:

    ```shell
    .\gradlew.bat publish
    ```

[1]: https://github.com/gradle/gradle/issues/888
[2]: https://s01.oss.sonatype.org/
[3]: https://s01.oss.sonatype.org/content/repositories/releases/garden/ephemeral/math/
