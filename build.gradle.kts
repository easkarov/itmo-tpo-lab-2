plugins {
    kotlin("jvm") version "2.0.21"
}

group = "se.ifmo.ru"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-csv:1.9.0")

    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("org.mockito:mockito-core:4.3.1")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}