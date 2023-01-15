package dev.tsnanh.android.core.ui.viewmodel

import dev.tsnanh.android.core.common.utils.UiMessageManager

internal interface ViewModelMessageHandler {
    val uiMessageManager: UiMessageManager

    companion object {
        fun create(): ViewModelMessageHandler = ViewModelMessageHandlerImpl()
    }
}

internal class ViewModelMessageHandlerImpl : ViewModelMessageHandler {
    override val uiMessageManager: UiMessageManager = UiMessageManager()
}

