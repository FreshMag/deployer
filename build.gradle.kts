
plugins {
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.gitSemVer) apply false
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.shadow) apply false
    alias(libs.plugins.taskTree) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    group = "io.github.freshmag"
}
