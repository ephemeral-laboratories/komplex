Komplex
=======

A simple complex math library for Kotlin.

Defines a `Complex` class with the usual operators you
would expect to be able to use with numbers.

Also defines a collection of functions, aiming for parity 
with the functions supported by `kotlin.math` for doubles,
but for complex numbers.

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
