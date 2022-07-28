package dev.tsnanh.android.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.core.navigation.contracts.SampleActivityContract
import dev.tsnanh.android.core.navigation.launch
import dev.tsnanh.android.feature.dashboard.databinding.FragmentDashboardBinding
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : ViewBindingFragment<FragmentDashboardBinding>() {
    @Inject
    lateinit var sampleActivityContract: SampleActivityContract

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding =
        FragmentDashboardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoToSampleActivity.setOnClickListener {
            launch(sampleActivityContract)
        }
    }
}
