package dev.tsnanh.android.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.tsnanh.android.core.ui.ObserveLoadingCounter
import dev.tsnanh.android.core.ui.Result
import dev.tsnanh.android.core.ui.UiMessageManager
import dev.tsnanh.android.core.ui.asResult
import dev.tsnanh.android.domain.observers.ObserveCharacterList
import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DashboardFragmentViewModel @Inject constructor(
    observeCharacterList: ObserveCharacterList,
    logger: Logger,
) : ViewModel() {
    private val uiMessageManager = UiMessageManager()
    val messages = uiMessageManager.messages

    private val loadingCounter = ObserveLoadingCounter()
    val isLoading = loadingCounter.flow

    val characters = observeCharacterList.flow.map { it.data.results }.asResult(
        loadingCounter = loadingCounter,
        uiMessageManager = uiMessageManager,
        logger = logger,
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = Result.Loading,
    )

    init {
        observeCharacterList(Unit)
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }
}
