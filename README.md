# Bonita CLI

CLI to interact with Bonita Platform

:warning: This is a Draft of a CLI that uses the new `bonita-java-client`


# Usage

try it out:

```
./gradlew run --args="process --username install --password install list"
```
gives:
```
class BusinessProcess {
    id: 5806012237157874793
    icon: null
    displayDescription:
    deploymentDate: 2020-10-22 09:34:44.909
    description:
    activationState: ENABLED
    name: ProcessWith2AutomaticTasks
    deployedBy: -1
    displayName: ProcessWith2AutomaticTasks
    actorinitiatorid: 1
    lastUpdateDate: 2020-10-22 09:34:45.113
    configurationState: RESOLVED
    version: 1.0
}
class BusinessProcess {
    id: 6809044125411765414
    icon: null
    displayDescription:
    deploymentDate: 2020-10-22 09:34:45.224
    description:
    activationState: ENABLED
    name: ProcessWithCallActivityAborted
    deployedBy: -1
    displayName: ProcessWithCallActivityAborted
    actorinitiatorid: 2
    lastUpdateDate: 2020-10-22 09:34:45.289
    configurationState: RESOLVED
    version: 1.0
}
class BusinessProcess {
    id: 5286653534038781085
    icon: null
    displayDescription:
    deploymentDate: 2020-10-22 09:34:45.398
    description:
    activationState: ENABLED
    name: StartXProcesses
    deployedBy: -1
    displayName: StartXProcesses
    actorinitiatorid: 3
    lastUpdateDate: 2020-10-22 09:34:45.481
    configurationState: RESOLVED
    version: 1.1
}
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
