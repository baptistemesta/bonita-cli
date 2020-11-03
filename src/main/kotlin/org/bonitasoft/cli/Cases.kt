package org.bonitasoft.cli

import picocli.CommandLine.Command
import picocli.CommandLine.Model.CommandSpec
import picocli.CommandLine.Spec
import java.util.concurrent.Callable


@Command(name = "case")
class Cases : BonitaCommand() {


    @Command(name = "list")
    fun list() {
        execute {
            processes().searchProcesses(0, 100).forEach {
                println(it)
            }
        }
    }


}