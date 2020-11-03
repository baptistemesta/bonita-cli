# Bonita CLI

CLI to interact with Bonita Platform

:warning: This is a Draft of a CLI that uses the new `bonita-java-client`


# Usage

try it out:

```
./gradlew run --args="process --username install --password install list"
```

example with the build version:

```
$./bin/bonita-cli process -h
Usage: bonita process [-hV] [--debug] [--disableCertificateCheck] [--info]
                      [--quiet] [-p[=<password>]] [-b=<url>]
                      [--connectTimeoutInSeconds=<connectTimeoutInSeconds>]
                      [--readTimeoutInSeconds=<readTimeoutInSeconds>]
                      -u=<username>
                      [--writeTimeoutInSeconds=<writeTimeoutInSeconds>]
                      [COMMAND]
  -b, --bonita=<url>   Url of the Bonita Platform
      --connectTimeoutInSeconds=<connectTimeoutInSeconds>

      --debug
      --disableCertificateCheck

  -h, --help           Show this help message and exit.
      --info
  -p, --password[=<password>]

      --quiet
      --readTimeoutInSeconds=<readTimeoutInSeconds>

  -u, --username=<username>

  -V, --version        Print version information and exit.
      --writeTimeoutInSeconds=<writeTimeoutInSeconds>

Commands:
  list
```
