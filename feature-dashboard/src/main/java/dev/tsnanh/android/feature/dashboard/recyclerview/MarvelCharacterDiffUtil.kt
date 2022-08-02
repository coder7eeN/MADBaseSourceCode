package dev.tsnanh.android.feature.dashboard.recyclerview

import androidx.recyclerview.widget.DiffUtil
import dev.tsnanh.core.models.MarvelCharacter

internal class MarvelCharacterDiffUtil : DiffUtil.ItemCallback<MarvelCharacter>() {
    override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
        return oldItem.id == newItem.id
    }
}
