plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
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
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("info.picocli:picocli:4.5.2")
    implementation("org.bonitasoft.web:bonita-java-client:0.0.1-SNAPSHOT")
    implementation("io.github.microutils:kotlin-logging:1.12.0")
    implementation("org.apache.logging.log4j:log4j-core:2.13.3")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.13.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

}

application {
    mainClassName = "org.bonitasoft.cli.AppKt"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
}