package dev.tsnanh.android.core.common.utils

import dev.tsnanh.android.core.common.logger.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface MADResult<out T> {
    data class Success<T>(val data: T) : MADResult<T>
    data class Error(val exception: Throwable? = null) : MADResult<Nothing>
    object Loading : MADResult<Nothing>
}

fun <T> Flow<T>.asResult(
    loadingCounter: ObserveLoadingCounter? = null,
    uiMessageManager: UiMessageManager? = null,
): Flow<MADResult<T>> {
    return this
        .map<T, MADResult<T>> {
            loadingCounter?.removeLoader()
            MADResult.Success(it)
        }
        .onStart {
            loadingCounter?.addLoader()
            emit(MADResult.Loading)
        }
        .catch {
            loadingCounter?.removeLoader()
            uiMessageManager?.emitMessage(UiMessage(it))
            emit(MADResult.Error(it))
        }
}

suspend inline fun <T> Flow<MADResult<T>>.collectResult(
    logger: Logger? = null,
    uiMessageManager: UiMessageManager? = null,
    crossinline onLoading: () -> Unit = {},
    crossinline onError: (Throwable) -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
) {
    collect { result ->
        when (result) {
            is MADResult.Error -> {
                val throwable = result.exception ?: Exception("Unknown exception")
                logger?.e(throwable)
                uiMessageManager?.emitMessage(UiMessage(throwable))
                onError(throwable)
            }
            MADResult.Loading -> onLoading()
            is MADResult.Success -> {
                onSuccess(result.data)
            }
        }
    }
}
