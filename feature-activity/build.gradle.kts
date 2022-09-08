plugins {
    id("dev.tsnanh.android.feature")
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "dev.tsnanh.android.feature.activity.sample"
}

dependencies {
    implementation(project(":core-testing"))
}
