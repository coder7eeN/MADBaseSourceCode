plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.spotless")
    id("dev.tsnanh.android.library.jacoco")
}

android {
    namespace = "dev.tsnanh.android.core.designsystem"
}

dependencies {
    implementation(libs.androidx.customview.poolingcontainer)
    implementation(libs.androidx.appcompat)
}
