package dev.tsnanh.android.core.ui

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class RecyclerViewAdapter<T, VH : LifecycleViewHolder>(
    diffUtil: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, VH>(diffUtil) {
    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.onAttachViewHolder()
    }
    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetachViewHolder()
    }
}
