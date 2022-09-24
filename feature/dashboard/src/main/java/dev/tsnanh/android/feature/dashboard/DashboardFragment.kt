package dev.tsnanh.android.feature.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.core.navigation.contracts.NavigationRoute
import dev.tsnanh.android.core.navigation.contracts.NoResultActivityContract
import dev.tsnanh.android.core.navigation.contracts.findContract
import dev.tsnanh.android.core.navigation.launch
import dev.tsnanh.android.feature.dashboard.databinding.FragmentDashboardBinding
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : ViewBindingFragment<FragmentDashboardBinding>() {

    @Inject
    lateinit var contracts: Map<String, NoResultActivityContract>

    override val viewInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding =
        FragmentDashboardBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGoToSampleActivity.setOnClickListener {
            launch(contract = contracts.findContract(NavigationRoute.USER))
        }
    }
}
