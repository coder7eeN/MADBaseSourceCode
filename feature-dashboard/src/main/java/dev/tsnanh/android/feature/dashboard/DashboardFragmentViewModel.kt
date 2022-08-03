package dev.tsnanh.android.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.tsnanh.android.core.ui.ObserveLoadingCounter
import dev.tsnanh.android.core.ui.Result
import dev.tsnanh.android.core.ui.UiMessageManager
import dev.tsnanh.android.core.ui.asResult
import dev.tsnanh.android.domain.observers.ObservePagedCharacterList
import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DashboardFragmentViewModel @Inject constructor(
    observePagedCharacterList: ObservePagedCharacterList,
    logger: Logger,
) : ViewModel() {
    private val uiMessageManager = UiMessageManager()
    val messages = uiMessageManager.messages

    private val loadingCounter = ObserveLoadingCounter()
    val isLoading = loadingCounter.flow

    val characters = observePagedCharacterList.flow.cachedIn(viewModelScope).asResult(
        loadingCounter = loadingCounter,
        uiMessageManager = uiMessageManager,
        logger = logger,
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = Result.Loading,
    )

    init {
        observePagedCharacterList(ObservePagedCharacterList.Params())
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }
}
