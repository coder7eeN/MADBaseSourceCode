package dev.tsnanh.android.core.common.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.UUID

data class UiMessage(
    val message: String,
    val id: Long = UUID.randomUUID().mostSignificantBits,
)

fun UiMessage(
    throwable: Throwable,
    id: Long = UUID.randomUUID().mostSignificantBits,
) = UiMessage(
    message = throwable.message ?: "Error: $throwable",
    id = id,
)

class UiMessageManager {
    private val mutex = Mutex()

    private val _messages = MutableStateFlow<List<UiMessage>>(listOf())

    val messages: Flow<UiMessage?> = _messages.map { it.firstOrNull() }.distinctUntilChanged()

    suspend fun emitMessage(uiMessage: UiMessage) {
        mutex.withLock {
            _messages.update { it + uiMessage }
        }
    }

    suspend fun clearMessage(id: Long) {
        mutex.withLock {
            _messages.update { it.filterNot { message -> message.id == id } }
        }
    }
}
