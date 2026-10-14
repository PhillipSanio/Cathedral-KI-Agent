plugins {
    kotlin("jvm") version "2.4.20"
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_26)
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.werthersechte:cathedral-ai:2.0.1")
    implementation("io.github.werthersechte:cathedral-game:2.0.0")
    implementation("io.github.werthersechte:cathedral-gui:2.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
    useJUnitPlatform()
}