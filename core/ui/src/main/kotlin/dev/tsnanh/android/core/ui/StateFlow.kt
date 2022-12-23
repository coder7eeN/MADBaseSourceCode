package dev.tsnanh.android.core.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

const val ANDROID_STOP_TIMEOUT_MILLIS = 5000L

@dev.tsnanh.android.core.ui.annotations.ExperimentalMADUiApi
@Suppress("NOTHING_TO_INLINE")
inline fun <T> Flow<dev.tsnanh.android.core.ui.utils.Result<T>>.bindState(
    viewModelScope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(ANDROID_STOP_TIMEOUT_MILLIS),
    initialState: dev.tsnanh.android.core.ui.utils.Result<T> = dev.tsnanh.android.core.ui.utils.Result.Loading,
) = stateIn(scope = viewModelScope, started = started, initialValue = initialState)
