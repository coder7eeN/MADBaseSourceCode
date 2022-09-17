package dev.tsnanh.android.core.ui

import dev.tsnanh.kotlin.base.InvokeError
import dev.tsnanh.kotlin.base.InvokeStarted
import dev.tsnanh.kotlin.base.InvokeStatus
import dev.tsnanh.kotlin.base.InvokeSuccess
import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import java.util.concurrent.atomic.AtomicInteger

class ObserveLoadingCounter {
    private val count: AtomicInteger = AtomicInteger()
    private val loadingState = MutableStateFlow(count.get())

    val flow: Flow<Boolean>
        get() = loadingState.map { it > 0 }.distinctUntilChanged()

    fun addLoader() {
        loadingState.update { count.incrementAndGet() }
    }

    fun removeLoader() {
        loadingState.update { count.decrementAndGet() }
    }
}

suspend fun Flow<InvokeStatus>.collectStatus(
    counter: ObserveLoadingCounter,
    logger: Logger? = null,
    uiMessageManager: UiMessageManager? = null
) = collect { status ->
    when (status) {
        is InvokeError -> {
            logger?.i(status.throwable)
            uiMessageManager?.emitMessage(UiMessage(status.throwable))
            counter.removeLoader()
        }
        InvokeStarted -> counter.addLoader()
        InvokeSuccess -> counter.removeLoader()
    }
}
