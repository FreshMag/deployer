import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.Instant

plugins {
    application
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.shadow)
    alias(libs.plugins.taskTree)
}

dependencies {
    implementation(libs.clikt)
    implementation(libs.jline)
    implementation(libs.mordant)
    implementation(libs.kotlin.coroutines.core)

    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.kotest.assertions.core.jvm)
    testImplementation(libs.kotest.runner.junit5)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        allWarningsAsErrors.set(true)
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

val gitHash =
    providers
        .exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
        }.standardOutput.asText
        .map { it.trim() }
        .orElse("unknown")

tasks.shadowJar {
    archiveVersion = providers.gradleProperty("releaseVersion").orElse("0.0.0-dev")
    archiveClassifier = ""
    archiveBaseName = "deployer"

    manifest {
        attributes(
            "Implementation-Title" to project.name,
            "Implementation-Version" to archiveVersion,
            "Implementation-Commit" to gitHash.get(),
            "Built-Timestamp" to Instant.now().toString(),
        )
    }
}

application {
    mainClass.set("io.github.deployer.MenuKt")
}

tasks.jar { enabled = false }

tasks.test {
    useJUnitPlatform()
}

detekt {
    config.from("../.detekt.yml")
    buildUponDefaultConfig = true
    parallel = true
}
