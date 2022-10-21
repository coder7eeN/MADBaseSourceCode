package dev.tsnanh.android.base

import android.os.Bundle

inline fun Bundle?.saveStates(block: Bundle.() -> Unit) {
    this?.block()
}

inline fun Bundle?.restoreStates(block: Bundle.() -> Unit) {
    this?.let { block(it) }
}
