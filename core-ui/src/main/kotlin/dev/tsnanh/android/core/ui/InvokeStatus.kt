package dev.tsnanh.android.core.ui

import dev.tsnanh.kotlin.base.InvokeStatus
import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
fun <T> Flow<T>.asResult(
    loadingCounter: ObserveLoadingCounter? = null,
    uiMessageManager: UiMessageManager? = null,
): Flow<InvokeStatus<T>> {
    return this
        .map<T, InvokeStatus<T>> {
            loadingCounter?.removeLoader()
            InvokeStatus.Success(it)
        }
        .onStart {
            loadingCounter?.addLoader()
            emit(InvokeStatus.Started)
        }
        .catch {
            loadingCounter?.removeLoader()
            uiMessageManager?.emitMessage(UiMessage(it))
            emit(InvokeStatus.Error(it))
        }
}

suspend inline fun <T> Flow<InvokeStatus<T>>.collectResult(
    logger: Logger? = null,
    uiMessageManager: UiMessageManager? = null,
    crossinline onLoading: () -> Unit = {},
    crossinline onError: (Throwable) -> Unit = {},
    crossinline onSuccess: (T) -> Unit,
) {
    collect { result ->
        when (result) {
            is InvokeStatus.Error -> {
                val throwable = result.exception ?: Exception("Unknown exception")
                logger?.e(throwable)
                uiMessageManager?.emitMessage(UiMessage(throwable))
                onError(throwable)
            }
            InvokeStatus.Started -> onLoading()
            is InvokeStatus.Success -> {
                onSuccess(result.data)
            }
        }
    }
}
