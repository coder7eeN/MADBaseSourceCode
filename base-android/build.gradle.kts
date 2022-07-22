plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("dev.tsnanh.spotless")
}

android {
    namespace = "dev.tsnanh.android.base"
}

dependencies {
    api(project(":base"))
}
