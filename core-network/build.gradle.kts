plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "dev.tsnanh.android.core.network"
}

dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-model"))
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.apache.commons.codec)
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}
