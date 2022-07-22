@file:Suppress("UnstableApiUsage")

include(":feature-profile")


include(":base-android")


include(":base")


include(":feature-search")


include(":core-database")


include(":core-testing")


include(":core-ui")


include(":core-model")


include(":feature-dashboard")


include(":domain")


include(":core-datastore")


include(":core-navigation")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if( requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.39.1")
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

include(":app")
include(":benchmark")
include(":convention")
include(":core-data")
include(":core-common")
include(":core-network")

// Enable Gradle's version catalog support
// https://docs.gradle.org/current/userguide/platforms.html
enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
