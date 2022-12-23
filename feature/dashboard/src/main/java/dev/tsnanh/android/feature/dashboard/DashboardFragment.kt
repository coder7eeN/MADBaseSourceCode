package dev.tsnanh.android.feature.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.feature.dashboard.databinding.FragmentDashboardBinding

@AndroidEntryPoint
class DashboardFragment : ViewBindingFragment<FragmentDashboardBinding>() {
    override val viewInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding =
        FragmentDashboardBinding::inflate
}
