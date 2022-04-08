// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.PluginNames.Id.AndroidApplication) version Versions.AndroidGradlePlugin apply false
    id(Plugins.PluginNames.Id.AndroidLibrary) version Versions.AndroidGradlePlugin apply false
    kotlin(Plugins.PluginNames.Kotlin.KotlinAndroid) version Versions.Kotlin apply false
    id("name.remal.check-dependency-updates") version "1.5.0"
    id("com.diffplug.spotless") version "6.4.2"
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    doLast {
        println("Delete build/ completed!")
    }
}

spotless {
    // optional: limit format enforcement to just the files changed by this feature branch
    ratchetFrom = "origin/develop"

    format("misc") {
        target("*.gradle", "*.md", ".gitignore")

        trimTrailingWhitespace()
        indentWithTabs()
        endWithNewline()
    }

    java {
        googleJavaFormat().aosp().reflowLongStrings()
        importOrder()
        removeUnusedImports()
        licenseHeader("/* (C)2022 */")
    }
    kotlin {
        ktlint()
        licenseHeader("/* (C)2022 */")
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
