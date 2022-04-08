object Libraries {
    object Coroutines {
        const val CoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines}"
        const val CoroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Coroutines}"
        const val CoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.CoroutinesAndroid}"
        const val SerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.SerializationJson}"
    }

    object AndroidX {
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.AppCompat}"
        const val AndroidXCore = "androidx.core:core-ktx:${Versions.AndroidXCore}"
        const val CoreSplashScreen = "androidx.core:core-splashscreen:${Versions.CoreSplashScreen}"
        const val Material = "com.google.android.material:material:${Versions.Material}"
        const val Timber = "com.jakewharton.timber:timber:${Versions.Timber}"
        const val CoreLibraryDesgaring =
            "com.android.tools:desugar_jdk_libs:${Versions.CoreLibraryDesugaring}"
        const val Navigation = "androidx.navigation:navigation-compose:${Versions.Navigation}"
    }

    object Compose {
        const val ComposeUI = "androidx.compose.ui:ui:${Versions.Compose}"
        const val ComposeUITooling =
            "androidx.compose.ui:ui-tooling:${Versions.Compose}"
        const val ComposeFoundation =
            "androidx.compose.foundation:foundation:${Versions.Compose}"
        const val ComposeMaterial =
            "androidx.compose.material:material:${Versions.Compose}"
        const val ComposeMaterialIconsCore =
            "androidx.compose.material:material-icons-core:${Versions.Compose}"
        const val ComposeMaterialIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.Compose}"
        const val ComposeLiveData =
            "androidx.compose.runtime:runtime-livedata:${Versions.Compose}"
        const val ActivityCompose =
            "androidx.activity:activity-compose:${Versions.ActivityCompose}"
        const val ComposeNavigation =
            "androidx.navigation:navigation-compose:${Versions.Navigation}"
    }

    object ComposeAccompanist {
        const val Insets = "com.google.accompanist:accompanist-insets:${Versions.Accompanist}"
        const val Permission =
            "com.google.accompanist:accompanist-permissions:${Versions.Accompanist}"
        const val SystemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.Accompanist}"
        const val DrawablePainter =
            "com.google.accompanist:accompanist-drawablepainter:${Versions.Accompanist}"
        const val NavigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:${Versions.Accompanist}"
        const val NavigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:${Versions.Accompanist}"
        const val Placeholder =
            "com.google.accompanist:accompanist-placeholder:${Versions.Accompanist}"
    }

    object Google {
        const val Material =
            "com.google.android.material:material:${Versions.Material}"
    }

    object Logging {
        const val Timber = "com.jakewharton.timber:timber:${Versions.Timber}"
    }

    object Arrow {
        const val ArrowCore = "io.arrow-kt:arrow-core:${Versions.Arrow}"
        const val ArrowCoroutines = "io.arrow-kt:arrow-fx-coroutines:${Versions.Arrow}"
        const val ArrowSTM = "io.arrow-kt:arrow-fx-stm:${Versions.Arrow}"
    }

    object Network {
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
        const val OkHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OkHttp}"
        const val KotlinSerializationRetrofitConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val OkHttp = "com.squareup.okhttp3:okhttp:${Versions.OkHttp}"
    }

    object Test {
        object Compose {
            const val ComposeUIJUnit4 =
                "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"
        }

        object Android {
            const val ComposeUIJUnit4 =
                "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"

            const val AndroidJUnit4 = "androidx.test.ext:junit:${Versions.AndroidJUnit4}"
            const val Espresso = "androidx.test.espresso:espresso-core:${Versions.Espresso}"
        }

        const val jUnit4 = "junit:junit:${Versions.JUnit4}"
    }
}
