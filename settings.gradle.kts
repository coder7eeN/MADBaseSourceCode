@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.42")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MADBaseSourceCode"

include(":convention")

include(":app")

include(":base")
include(":base-android")

include(":benchmark")

include(":core-data")
include(":core-common")
include(":core-datastore")
include(":core-navigation")
include(":core-network")
include(":core-database")
include(":core-testing")
include(":core-ui")
include(":core-model")

include(":domain")

include(":feature-activity")
include(":feature-profile")
include(":feature-search")
include(":feature-dashboard")

// Enable Gradle's version catalog support
// https://docs.gradle.org/current/userguide/platforms.html
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
