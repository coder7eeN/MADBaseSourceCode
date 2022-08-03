package dev.tsnanh.android.feature.dashboard.recyclerview

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import dev.tsnanh.core.models.MarvelCharacter
import javax.inject.Inject

internal class MarvelCharacterListAdapter @Inject constructor() :
    PagingDataAdapter<MarvelCharacter, MarvelCharacterViewHolder>(MarvelCharacterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MarvelCharacterViewHolder.from(parent)

    override fun onBindViewHolder(holder: MarvelCharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
