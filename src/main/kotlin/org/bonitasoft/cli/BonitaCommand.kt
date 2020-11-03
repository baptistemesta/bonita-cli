package org.bonitasoft.cli

import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.core.LoggerContext
import org.bonitasoft.web.client.BonitaClient
import org.bonitasoft.web.client.log.LogContentLevel
import picocli.CommandLine.*


@Command(mixinStandardHelpOptions = true)
abstract class BonitaCommand : Runnable {

    @Option(names = ["-u", "--username"], required = true)
    lateinit var username: String
    @Option(names = ["-p", "--password"], arity = "0..1", interactive = true)
    lateinit var password: String
    @Option(names = ["-b", "--bonita"], required = true, defaultValue = "http://localhost:8080/bonita", description = ["Url of the Bonita Platform"])
    lateinit var url: String
    @Option(names = ["--connectTimeoutInSeconds"])
    var connectTimeoutInSeconds: Int? = null
    @Option(names = ["--readTimeoutInSeconds"])
    var readTimeoutInSeconds: Int? = null
    @Option(names = ["--writeTimeoutInSeconds"])
    var writeTimeoutInSeconds: Int? = null
    @Option(names = ["--disableCertificateCheck"])
    var disableCertificateCheck: Boolean? = null

    @Option(names = ["--quiet"])
    var quiet: Boolean = false
    @Option(names = ["--info"])
    var info: Boolean = false
    @Option(names = ["--debug"])
    var debug: Boolean = false


    @Spec

    lateinit var spec: Model.CommandSpec

    override fun run() {
        configureLogger()

        val builder = BonitaClient.builder(url)
        connectTimeoutInSeconds?.let { builder.connectTimeoutInSeconds(it) }
        readTimeoutInSeconds?.let { builder.readTimeoutInSeconds(it) }
        writeTimeoutInSeconds?.let { builder.writeTimeoutInSeconds(it) }
        disableCertificateCheck?.let { builder.disableCertificateCheck(it) }
        builder.logContentLevel( when{
            quiet -> LogContentLevel.OFF
            info -> LogContentLevel.BASIC
            debug -> LogContentLevel.FULL
            else -> LogContentLevel.OFF
        })

        val client = builder.build()

        client.login(username, password)
        execute(client)
        client.logout()
    }

    private fun configureLogger() {
        val level = when{
            quiet -> Level.OFF
            info -> Level.INFO
            debug -> Level.DEBUG
            else -> Level.ERROR
        }
        val ctx: LoggerContext = LogManager.getContext(false) as LoggerContext
        ctx.configuration.rootLogger.level = level
    }

    abstract fun execute(client: BonitaClient)

}