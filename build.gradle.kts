import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.taskTree)
}

group = "io.github.freshmag"

repositories {
    google()
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
    sourceSets.main {
        kotlin.srcDir(layout.buildDirectory.dir("generatedAntlr"))
    }
}

dependencies {
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.kotest.assertions.core.jvm)
    testImplementation(libs.kotest.runner.junit5)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        allWarningsAsErrors.set(true)
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

detekt {
    config.from(".detekt.yml")
    buildUponDefaultConfig = true
    parallel = true
}
