plugins {
    id("dev.tsnanh.android.feature")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
    kotlin("kapt")
}

android { namespace = "dev.tsnanh.android.feature.search" }
