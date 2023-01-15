package dev.tsnanh.android.core.ui.viewmodel

import dev.tsnanh.android.core.common.utils.ObserveLoadingCounter

internal interface ViewModelLoading {
    val loadingCounter: ObserveLoadingCounter

    companion object {
        fun create(): ViewModelLoading = ViewModelLoadingImpl()
    }
}

internal class ViewModelLoadingImpl : ViewModelLoading {
    override val loadingCounter: ObserveLoadingCounter =
        ObserveLoadingCounter()
}
