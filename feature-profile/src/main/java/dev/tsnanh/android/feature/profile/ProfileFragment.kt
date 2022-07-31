package dev.tsnanh.android.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.core.ui.collectResult
import dev.tsnanh.android.feature.profile.databinding.FragmentProfileBinding
import dev.tsnanh.kotlin.base.util.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : ViewBindingFragment<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding =
        FragmentProfileBinding::inflate

    @Inject
    lateinit var logger: Logger

    private val viewModel: ProfileFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                observeProfileUiState()
                observeLoadingState()
                observeSnackBarMessage()
            }
        }
    }

    private fun CoroutineScope.observeSnackBarMessage() {
        launch {
            viewModel.messages.collect { message ->
                message?.let {
                    Snackbar.make(requireView(), "Djt con me loi roi", Snackbar.LENGTH_LONG).show()
                    viewModel.clearMessage(it.id)
                }
            }
        }
    }

    private fun CoroutineScope.observeLoadingState() {
        launch {
            viewModel.isLoading.collect { isLoading ->
                if (isLoading) {
                    binding.textView.text = "Loading..."
                }
            }
        }
    }

    private fun CoroutineScope.observeProfileUiState() {
        launch {
            viewModel.profileUiState.collectResult(
                onError = {
                    binding.textView.text = "Error!"
                },
                onSuccess = {
                    logger.d("", "onViewCreated: $it")
                    binding.textView.text = it.toString()
                }
            )
        }
    }
}
