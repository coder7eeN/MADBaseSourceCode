package dev.tsnanh.android.madbasesourcecode

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dev.tsnanh.kotlin.base.util.Logger
import javax.inject.Inject

@HiltAndroidApp
class MADApplication : Application() {
    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.setup(BuildConfig.DEBUG)
    }
}
