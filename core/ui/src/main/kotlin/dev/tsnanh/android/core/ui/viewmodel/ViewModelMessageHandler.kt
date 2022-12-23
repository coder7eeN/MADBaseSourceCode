package dev.tsnanh.android.core.ui.viewmodel

internal interface ViewModelMessageHandler {
    val uiMessageManager: dev.tsnanh.android.core.ui.utils.UiMessageManager

    companion object {
        fun create(): ViewModelMessageHandler = ViewModelMessageHandlerImpl()
    }
}

internal class ViewModelMessageHandlerImpl : ViewModelMessageHandler {
    override val uiMessageManager: dev.tsnanh.android.core.ui.utils.UiMessageManager =
        dev.tsnanh.android.core.ui.utils.UiMessageManager()
}

