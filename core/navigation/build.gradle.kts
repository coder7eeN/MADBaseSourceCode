@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.ksp)
    id("dev.tsnanh.spotless")
}

dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
    api(libs.androidx.navigation.fragment)
    api(libs.androidx.navigation.ui)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
