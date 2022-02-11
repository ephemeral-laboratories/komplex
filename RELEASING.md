Releasing this Software
=======================

Manual process:

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
    ```shell
    .\gradlew.bat publish
    ```

[1]: https://github.com/gradle/gradle/issues/888
