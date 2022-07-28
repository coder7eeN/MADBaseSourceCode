plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "dev.tsnanh.android.base"
}

dependencies {
    api(project(":base"))
    implementation(libs.androidx.appcompat)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.timber)
}
