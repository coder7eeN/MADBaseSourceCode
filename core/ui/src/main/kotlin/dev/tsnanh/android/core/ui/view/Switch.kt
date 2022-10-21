package dev.tsnanh.android.core.ui

import androidx.appcompat.widget.SwitchCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

val SwitchCompat.isOn: Flow<Boolean>
    get() = callbackFlow {
    setOnCheckedChangeListener { _, isChecked ->
        trySend(isChecked)
    }
    awaitClose {
        setOnCheckedChangeListener(null)
    }
}.flowOn(Dispatchers.Main)
