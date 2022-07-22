plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    kotlin("kapt")
}

android {
    namespace = "dev.tsnanh.android.core.datastore"
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
}
