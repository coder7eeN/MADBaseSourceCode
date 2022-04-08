object Plugins {
    object PluginNames {
        // Use id() function to apply plugin
        object Id {
            const val AndroidApplication = "com.android.application"
            const val AndroidLibrary = "com.android.library"
            const val Detekt = "io.gitlab.arturbosch.detekt"
            const val Ktlint = "org.jlleitschuh.gradle.ktlint"
            const val Hilt = "dagger.hilt.android.plugin"
            const val GoogleServices = "com.google.gms.google-services"
            const val Crashlytics = "com.google.firebase.crashlytics"
        }

        // Use kotlin() function to apply plugin
        object Kotlin {
            const val KotlinAndroid = "android"
            const val KotlinKapt = "kapt"
            const val KotlinParcelize = "kotlin-parcelize"
        }
    }

    object PluginDependencies {
        const val KotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
        const val AndroidGradlePlugin =
            "com.android.tools.build:gradle:${Versions.AndroidGradlePlugin}"
        const val AndroidGradlePluginApi =
            "com.android.tools.build:gradle-api:${Versions.AndroidGradlePlugin}"
        const val KotlinSerializationPlugin =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.Kotlin}"
        const val GoogleServices = "com.google.gms:google-services:${Versions.GoogleServices}"
        const val Crashlytics =
            "com.google.firebase:firebase-crashlytics-gradle:${Versions.Crashlytics}"
    }
}
