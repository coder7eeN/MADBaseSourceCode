plugins {
    id(Plugins.PluginNames.Id.AndroidApplication)
    kotlin(Plugins.PluginNames.Kotlin.KotlinAndroid)
    kotlin(Plugins.PluginNames.Kotlin.KotlinKapt)
}

android {
    compileSdk = Configs.CompileSdkVersion

    defaultConfig {
        applicationId = Configs.ApplicationId
        minSdk = Configs.MinSdkVersion
        targetSdk = Configs.TargetSdkVersion
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        allWarningsAsErrors = true
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    }
}

dependencies {
    coreLibraryDesugaring(Libraries.AndroidX.CoreLibraryDesgaring)

    implementation(Libraries.AndroidX.AndroidXCore)
    implementation(Libraries.AndroidX.AppCompat)
    implementation(Libraries.Google.Material)
    testImplementation(Libraries.Test.jUnit4)
    // androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    // androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
