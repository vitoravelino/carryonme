[![Build Status](https://travis-ci.org/vitoravelino/carryonme.png)](https://travis-ci.org/vitoravelino/carryonme)

Carry On Me
==========

## About


## Features

## Developing

*   **run.py**: runs the project on two modes: *testing* and *server*;
    *   **testing**: watch for modifications on the *src* folder and runs *gradle test*;
    *   **server**: runs *gradle run*, then watch for modification on the *src* and runs *gradle war* to compile and copy
        all modified files to the running directory. Modification to class files will be hot reloaded, thanks to [spring-loaded](https://github.com/SpringSource/spring-loaded).

### Other useful *gradle* tasks

*   **reports** - generate several reports for the project: *tests results*, *code coverage* and *javadoc*;
*   **eclipse** - generates/update eclipse *.project* and *.classpath* files - if using eclipse you'll need to run this command everytime you change your dependencies;
*   **dependencyUpdates** - ;
*   **license**(?) - update the source file's header with the license header from **resources/HEADER.license**.

