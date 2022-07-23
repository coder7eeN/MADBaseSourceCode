@file:Suppress("UnstableApiUsage")

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
}

android {
    namespace = "dev.tsnanh.android.core.ui"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.2")
}
