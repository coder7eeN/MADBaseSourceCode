package dev.tsnanh.android.feature.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.base.ViewBindingFragment
import dev.tsnanh.android.feature.profile.databinding.FragmentProfileBinding

@AndroidEntryPoint
class ProfileFragment : ViewBindingFragment<FragmentProfileBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding =
        FragmentProfileBinding::inflate
}
