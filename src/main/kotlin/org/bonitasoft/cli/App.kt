package org.bonitasoft.cli

import picocli.CommandLine
import picocli.CommandLine.Command
import kotlin.system.exitProcess


@Command(name = "bonita", mixinStandardHelpOptions = true, version = ["0.0"],
        subcommands = [
            Processes::class,
            Cases::class
        ]

)
class App {


}

fun main(args: Array<String>) {
    exitProcess(CommandLine(App()).execute(*args))
}
