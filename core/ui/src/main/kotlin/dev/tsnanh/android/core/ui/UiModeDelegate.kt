package dev.tsnanh.android.core.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowInsetsControllerCompat

interface UiModeDelegate {
    fun AppCompatActivity.handleUiModeChange(configuration: Configuration)

    fun AppCompatActivity.configureDefaultSystemBarsAppearance()

    companion object : UiModeDelegate {
        override fun AppCompatActivity.handleUiModeChange(configuration: Configuration) {
            when (configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_NO -> changeUiModeToDark()
                Configuration.UI_MODE_NIGHT_YES -> changeUiModeToLight()
            }
        }

        override fun AppCompatActivity.configureDefaultSystemBarsAppearance() {
            WindowInsetsControllerCompat(window, window.decorView).run {
                isAppearanceLightStatusBars = true
                isAppearanceLightNavigationBars = true
            }
        }

        private fun AppCompatActivity.changeUiModeToDark() {
            ActivityCompat.recreate(this)
            WindowInsetsControllerCompat(window, window.decorView).run {
                isAppearanceLightStatusBars = true
                isAppearanceLightNavigationBars = true
            }
        }

        private fun AppCompatActivity.changeUiModeToLight() {
            ActivityCompat.recreate(this)
            WindowInsetsControllerCompat(window, window.decorView).run {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        }
    }
}
