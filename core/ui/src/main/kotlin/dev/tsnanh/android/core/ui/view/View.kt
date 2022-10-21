package dev.tsnanh.android.core.ui

import android.content.res.TypedArray
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

fun View.show() {
    isVisible = true
}

fun View.hide() {
    isVisible = false
}

fun View.invisible() {
    isInvisible = true
}

fun View.addRippleEffect() {
    val attrs = intArrayOf(com.google.android.material.R.attr.selectableItemBackgroundBorderless)
    val typedArray: TypedArray = context.obtainStyledAttributes(attrs)
    val backgroundResource = typedArray.getResourceId(0, 0)
    typedArray.recycle()
    setBackgroundResource(backgroundResource)
}

val View.click
    get() = callbackFlow {
        setOnClickListener {
            trySend(it)
        }

        awaitClose {
            setOnClickListener(null)
        }
    }.flowOn(context = Dispatchers.Main)

val View.silentClick: Flow<View>
    get() {
        isSoundEffectsEnabled = false
        return click
    }
