<p align="center">
    <img width=60% src="resources/img/logo.png">
</p>
<p align="center">
    <a href="https://kotlinlang.org/"><img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=Kotlin&logoColor=white"></a>  
    <a href="https://github.com/FreshMag/deployer/blob/main/LICENSE"><img src="https://img.shields.io/github/license/FreshMag/deployer.svg?style=flat"></a>
    <a href="https://conventionalcommits.org"><img src="https://img.shields.io/badge/Conventional%20Commits-1.0.0-%23FE5196?logo=conventionalcommits"></a>
    <a href="https://github.com/FreshMag/deployer/actions"><img src="https://github.com/FreshMag/deployer/actions/workflows/dispatcher.yml/badge.svg"></a>
    <a href="https://ktlint.github.io/"><img src="https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg"></a>
    <img src="https://img.shields.io/github/repo-size/FreshMag/deployer">
</p>

## Overview

**Deployer** is a tool to facilitate deployment of war files to wildfly servers.

## Quick start

1. Download the latest release from the [Releases](https://www.github.com/FreshMag/deployer/releases) page.
2. Create a script to run the jar file. For example, create a file named `deployer.sh` with the following content:
    ```sh
    #!/bin/sh
    java -jar path/to/deployer.jar "$@"
    ```
   Or in windows, create a file named `deployer.bat` with the following content:
    ```bat
    @echo off
    java -jar path\to\deployer.jar %*
    ```
3. Make the script executable:
    ```sh
    chmod +x deployer.sh
    ```
4. (Optional) Move the script to a directory in your system's PATH for easier access:
    ```sh
    mv deployer.sh /usr/local/bin/deployer
    ```
5. Run the deployer with the desired arguments. For example:
    ```sh
    ./deployer.sh --in-place
    ```
