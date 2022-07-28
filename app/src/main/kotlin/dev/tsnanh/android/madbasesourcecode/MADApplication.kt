package dev.tsnanh.android.madbasesourcecode

import android.app.Application
import coil.Coil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MADApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
