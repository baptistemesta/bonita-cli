package org.bonitasoft.cli

import org.bonitasoft.web.client.BonitaClient
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters


@Command(name = "process")
class Processes: BonitaCommand() {


    @Command(name = "list")
    fun list() {
        execute {
            processes().searchProcesses(0, 100).forEach {
                println(it)
            }
        }
    }

    @Command(name = "start")
    fun start(@Parameters(index = "0") name: String, @Parameters(index = "1") version: String) {
        execute {
            val process = processes().getProcess(name, version)
            process.ifPresent {
                val case = processes().startProcess(it.id)
                println("Started case ${case.caseId}")
            }
            process.orElseThrow { CommandLine.ParameterException(spec.commandLine(), "Process $name in version $version does not exists") }
        }
    }


}