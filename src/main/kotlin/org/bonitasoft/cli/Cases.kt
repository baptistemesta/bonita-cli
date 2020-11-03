package org.bonitasoft.cli

import picocli.CommandLine.Command
import picocli.CommandLine.Model.CommandSpec
import picocli.CommandLine.Spec
import java.util.concurrent.Callable


@Command(name = "case")
class Cases  : Callable<Int> {
    @Spec
    var spec: CommandSpec? = null
    override fun call(): Int {
        TODO("Not yet implemented")
    }

}