package org.bonitasoft.cli

import org.bonitasoft.web.client.BonitaClient
import picocli.CommandLine
import picocli.CommandLine.Command


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


}