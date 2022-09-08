@file:Suppress("UnstableApiUsage")

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.compose")
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
    implementation(project(":base"))
    implementation(project(":core-model"))
    implementation(project(":core-testing"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.datetime)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    debugApi(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.runtime.livedata)
    api(libs.androidx.appcompat)
    api(libs.androidx.constraintlayout)
    // api(libs.androidx.metrics)
    // api(libs.androidx.tracing.ktx)
}
