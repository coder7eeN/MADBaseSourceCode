package dev.tsnanh.android.core.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.activity.result.contract.ActivityResultContract
import kotlinx.parcelize.Parcelize

abstract class BaseContract<Args : Parcelable, Result : Parcelable>(
    private val activityClass: Class<out Activity>,
) : ActivityResultContract<Args, Result>() {
    companion object {
        private const val INTENT_ARGS = "contract.intent.args"
        private const val INTENT_RESULT = "contract.intent.result"
    }

    override fun createIntent(context: Context, input: Args): Intent {
        return Intent(context, activityClass).apply {
            putExtra(INTENT_ARGS, input)
        }
    }
    fun createResultIntent(result: Result): Intent {
        return Intent().apply {
            putExtra(INTENT_RESULT, result)
        }
    }
}

@Parcelize
object NoArgs : Parcelable

@Parcelize
object NoResult : Parcelable
