package dev.tsnanh.android.core.ui

internal interface ViewModelLoading {
    val loadingCounter: ObserveLoadingCounter

    companion object {
        fun create(): ViewModelLoading = ViewModelLoadingImpl()
    }
}

internal class ViewModelLoadingImpl : ViewModelLoading {
    override val loadingCounter: ObserveLoadingCounter = ObserveLoadingCounter()
}
