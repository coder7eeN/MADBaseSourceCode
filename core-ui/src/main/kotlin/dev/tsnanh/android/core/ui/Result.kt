package dev.tsnanh.android.core.ui

import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(
    loadingCounter: ObserveLoadingCounter? = null,
    uiMessageManager: UiMessageManager? = null,
    logger: Logger? = null,
): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            loadingCounter?.removeLoader()
            Result.Success(it)
        }
        .onStart {
            loadingCounter?.addLoader()
            emit(Result.Loading)
        }
        .catch {
            logger?.e("===API ERROR===")
            logger?.e(it)
            loadingCounter?.removeLoader()
            uiMessageManager?.emitMessage(UiMessage(it))
            emit(Result.Error(it))
        }
}

suspend inline fun <T> Flow<Result<T>>.fold(
    logger: Logger? = null,
    uiMessageManager: UiMessageManager? = null,
    crossinline onLoading: () -> Unit = {},
    crossinline onError: (Throwable) -> Unit,
    crossinline onSuccess: (T) -> Unit,
) {
    collect { result ->
        when (result) {
            is Result.Error -> {
                val throwable = result.exception ?: Exception("Unknown exception")
                logger?.e(throwable)
                uiMessageManager?.emitMessage(UiMessage(throwable))
                onError(throwable)
            }
            Result.Loading -> onLoading()
            is Result.Success -> {
                onSuccess(result.data)
            }
        }
    }
}
