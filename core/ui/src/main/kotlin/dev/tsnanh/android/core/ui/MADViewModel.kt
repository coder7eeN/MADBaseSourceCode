package dev.tsnanh.android.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class MADViewModel : ViewModel(), ViewModelLoading by ViewModelLoading.create(),
    ViewModelMessageHandler by ViewModelMessageHandler.create() {
    fun sendMessage(uiMessage: UiMessage) {
        viewModelScope.launch {
            uiMessageManager.emitMessage(uiMessage)
        }
    }

    fun clearMessage(messageId: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(messageId)
        }
    }
}
