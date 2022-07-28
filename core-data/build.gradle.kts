plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("kotlinx-serialization")
}

dependencies {
    implementation(project(":core-common"))
    api(project(":core-model"))
    implementation(project(":core-database"))
    implementation(project(":core-datastore"))
    implementation(project(":core-network"))

    implementation(libs.kotlinx.datetime)
    api(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    api(libs.androidx.paging.runtime)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
