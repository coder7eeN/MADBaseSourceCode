@file:Incubating
@file:Suppress(
    "UnstableApiUsage",
    "DSL_SCOPE_VIOLATION",
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED"
)

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()

        // Used for Accompanist snapshots
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.kotlin.serializationPlugin)
        classpath(libs.hilt.gradlePlugin)
        classpath(libs.secrets.gradlePlugin)
        classpath(libs.google.gmsGoogleServices)
        classpath(libs.google.crashlyticsGradle)
    }
}

plugins {
    alias(libs.plugins.spotless)
    alias(libs.plugins.gradleDependencyUpdate)
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
}

apply(from = "./gradle/dependencyGraph.gradle")
