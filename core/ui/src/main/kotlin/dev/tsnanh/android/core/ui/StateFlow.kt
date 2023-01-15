package dev.tsnanh.android.core.ui

import dev.tsnanh.android.core.common.annotations.ExperimentalMADUiApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

const val ANDROID_STOP_TIMEOUT_MILLIS = 5_000L

@ExperimentalMADUiApi
@Suppress("NOTHING_TO_INLINE")
inline fun <T> Flow<dev.tsnanh.android.core.common.utils.MADResult<T>>.bindState(
    viewModelScope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(ANDROID_STOP_TIMEOUT_MILLIS),
    initialState: dev.tsnanh.android.core.common.utils.MADResult<T> = dev.tsnanh.android.core.common.utils.MADResult.Loading,
) = stateIn(scope = viewModelScope, started = started, initialValue = initialState)
