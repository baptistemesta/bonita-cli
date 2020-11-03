package org.bonitasoft.cli

import org.bonitasoft.web.client.BonitaClient
import picocli.CommandLine


@CommandLine.Command(name = "process")
class Processes: BonitaCommand() {
    override fun execute(client: BonitaClient) {
        client.processes().searchProcesses(0,100).forEach{
            println(it)
        }
    }


}