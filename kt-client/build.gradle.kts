plugins {
    kotlin("jvm") version "1.9.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
}

application {
    mainClass.set("MainKt")
}

