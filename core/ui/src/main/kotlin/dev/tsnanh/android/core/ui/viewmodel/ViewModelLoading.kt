package dev.tsnanh.android.core.ui.viewmodel

internal interface ViewModelLoading {
    val loadingCounter: dev.tsnanh.android.core.ui.utils.ObserveLoadingCounter

    companion object {
        fun create(): ViewModelLoading = ViewModelLoadingImpl()
    }
}

internal class ViewModelLoadingImpl : ViewModelLoading {
    override val loadingCounter: dev.tsnanh.android.core.ui.utils.ObserveLoadingCounter =
        dev.tsnanh.android.core.ui.utils.ObserveLoadingCounter()
}
