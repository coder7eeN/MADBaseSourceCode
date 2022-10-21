package dev.tsnanh.android.core.ui

internal interface ViewModelMessageHandler {
    val uiMessageManager: UiMessageManager

    companion object {
        fun create(): ViewModelMessageHandler = ViewModelMessageHandlerImpl()
    }
}

internal class ViewModelMessageHandlerImpl : ViewModelMessageHandler {
    override val uiMessageManager: UiMessageManager = UiMessageManager()
}

