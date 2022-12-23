package dev.tsnanh.android.core.ui.recyclerview

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.tsnanh.kotlin.base.annotations.ExperimentalMADApi

@ExperimentalMADApi
abstract class RecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(
    diffUtil: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, VH>(diffUtil) {
    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        (holder as? LifecycleViewHolder)?.onRecycled()
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        (holder as? LifecycleViewHolder)?.onAttachViewHolder()
    }
    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        (holder as? LifecycleViewHolder)?.onDetachViewHolder()
    }
}
