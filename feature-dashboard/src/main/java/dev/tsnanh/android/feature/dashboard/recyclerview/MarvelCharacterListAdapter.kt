package dev.tsnanh.android.feature.dashboard.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import dev.tsnanh.core.models.MarvelCharacter
import javax.inject.Inject

internal class MarvelCharacterListAdapter @Inject constructor() :
    ListAdapter<MarvelCharacter, MarvelCharacterViewHolder>(MarvelCharacterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MarvelCharacterViewHolder.from(parent)

    override fun onBindViewHolder(holder: MarvelCharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
