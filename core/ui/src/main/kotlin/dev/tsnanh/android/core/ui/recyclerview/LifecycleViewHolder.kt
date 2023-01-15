package dev.tsnanh.android.core.ui.recyclerview

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import dev.tsnanh.android.core.common.annotations.ExperimentalMADUiApi

@ExperimentalMADUiApi
abstract class LifecycleViewHolder protected constructor(
    view: View,
) : RecyclerView.ViewHolder(view), LifecycleOwner, ViewModelStoreOwner {
    private var viewModelStore = ViewModelStore()

    private lateinit var lifecycleRegistry: LifecycleRegistry

    protected var viewModel: ViewModel? = null

    init {
        initializeRegistry()
        initializeViewModel()
    }

    protected open fun createViewModel(): ViewModel? = null

    private fun initializeViewModel() {
        viewModel = createViewModel()
    }

    private fun initializeRegistry() {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun getViewModelStore() = viewModelStore

    override fun getLifecycle() = lifecycleRegistry

    fun onAttachViewHolder() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    fun onDetachViewHolder() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    fun onRecycled() {
        //Change lifecycle stage to destroy and clear the ViewModelStore
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        viewModelStore.clear()
        //view is sent to recyclerViewPool,
        //as view will be reused again, we need to re initialize view model //and create its lifecycle
        initializeRegistry()
        initializeViewModel()
    }
}
