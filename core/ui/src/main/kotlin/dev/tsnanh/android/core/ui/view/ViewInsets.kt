package dev.tsnanh.android.core.ui.view

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

inline fun View.windowInsets(crossinline block: WindowInsetsCompat.(View) -> Unit) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        insets.block(v)
        insets
    }
}

inline val WindowInsetsCompat.statusBarsTopPadding: Int get() = getInsets(WindowInsetsCompat.Type.statusBars()).top
inline val WindowInsetsCompat.navigationBarsBottomPadding: Int get() = getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
inline val WindowInsetsCompat.navigationBarsWithImeBottomPadding: Int
    get() = getInsets(WindowInsetsCompat.Type.ime() or WindowInsetsCompat.Type.navigationBars()).bottom
