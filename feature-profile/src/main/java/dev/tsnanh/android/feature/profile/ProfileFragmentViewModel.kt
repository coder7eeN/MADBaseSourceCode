package dev.tsnanh.android.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.tsnanh.android.core.ui.*
import dev.tsnanh.android.domain.observers.ObserveCharacterList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProfileFragmentViewModel @Inject constructor(
    observeCharacterList: ObserveCharacterList,
) : ViewModel() {
    private val uiMessageManager = UiMessageManager()
    val messages = uiMessageManager.messages

    private val loadingCounter = ObserveLoadingCounter()
    val isLoading = loadingCounter.flow

    val profileUiState = observeCharacterList.flow.asResult(
        loadingCounter, uiMessageManager
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
