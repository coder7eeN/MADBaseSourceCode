package dev.tsnanh.android.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.core.ui.fold
import dev.tsnanh.android.feature.dashboard.databinding.FragmentDashboardBinding
import dev.tsnanh.android.feature.dashboard.recyclerview.MarvelCharacterListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
internal class DashboardFragment : ViewBindingFragment<FragmentDashboardBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding =
        FragmentDashboardBinding::inflate

    @Inject
    lateinit var marvelCharacterListAdapter: MarvelCharacterListAdapter

    private val viewModel by viewModels<DashboardFragmentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                observeProfileUiState()
                observeLoadingState()
                observeSnackBarMessage()
            }
        }
    }

    private fun setupList() = with(binding.listMarvelCharacters) {
        setHasFixedSize(true)
        layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = marvelCharacterListAdapter
    }

    private fun CoroutineScope.observeSnackBarMessage() {
        launch {
            viewModel.messages.collect { message ->
                message?.let {
                    Snackbar.make(
                        requireView(),
                        "Djt con me loi roi",
                        Snackbar.LENGTH_LONG
                    ).show()
                    viewModel.clearMessage(it.id)
                }
            }
        }
    }

    private fun CoroutineScope.observeLoadingState() {
        launch {
            viewModel.isLoading.collect { isLoading ->
                binding.cprogressMarvelCharacters.isVisible = isLoading
                binding.listMarvelCharacters.isVisible = !isLoading
            }
        }
    }

    private fun CoroutineScope.observeProfileUiState() {
        launch {
            viewModel.characters.fold(
                onError = {},
                onSuccess = {
                    val characterHasThumbnail = it
                    marvelCharacterListAdapter.submitData(lifecycle, characterHasThumbnail)
                }
            )
        }
    }
}
