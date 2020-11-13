plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    id("org.mikeneck.graalvm-native-image") version "v0.8.0"
    application
}

group = "org.bonitasoft.cli"

repositories {
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    jcenter()
}

dependencies {
    kapt("info.picocli:picocli-codegen:4.5.2")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("info.picocli:picocli:4.5.2")
    implementation("org.bonitasoft.web:bonita-java-client:0.0.1")
    implementation("io.github.microutils:kotlin-logging:1.12.0")
    implementation("org.apache.logging.log4j:log4j-core:2.13.3")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.13.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

}

application {
    mainClass.set("org.bonitasoft.cli.AppKt")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}

nativeImage {
    graalVmHome = System.getenv("JAVA_HOME")
    mainClass = "org.bonitasoft.cli.AppKt"
    executableName = "bonita"
    outputDirectory = file("$buildDir/executable")
    arguments(
            "--no-fallback",
            "--enable-all-security-services",
//            "--initialize-at-run-time=com.example.runtime",
            "--report-unsupported-elements-at-runtime",
            "--allow-incomplete-classpath"
    )
    withConfigFiles {
        addReflectConfig(file("refletotoct.json"))
    }
}