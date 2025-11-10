package io.github.deployer

object MainKt {
    fun appVersion(): String {
        val attrs =
            object {}
                .javaClass
                .getResourceAsStream("/META-INF/MANIFEST.MF")
                ?.use {
                    java.util.jar
                        .Manifest(it)
                        .mainAttributes
                }
        val ver = attrs?.getValue("Implementation-Version") ?: "dev"
        val commit = attrs?.getValue("Implementation-Commit")
        return if (commit.isNullOrBlank()) ver else "$ver ($commit)"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.contains("-v") || args.contains("--version")) {
            println(appVersion())
            return
        }
        // ...rest of your app
    }
}
