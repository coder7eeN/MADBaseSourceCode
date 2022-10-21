package dev.tsnanh.android.core.ui

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackbar(message: UiMessage?, duration: Int = Snackbar.LENGTH_SHORT) =
    message?.run {
        Snackbar.make(requireView(), message.message, duration).show()
    }
