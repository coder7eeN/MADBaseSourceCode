package dev.tsnanh.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    protected val binding: T get() = _binding ?: throw IllegalAccessException("Dkm goi binding ngu vcl")

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater(inflater, container, false)
        onCreateView(binding, savedInstanceState)
        return binding.root
    }

    open fun onCreateView(binding: T, savedInstanceState: Bundle?) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
