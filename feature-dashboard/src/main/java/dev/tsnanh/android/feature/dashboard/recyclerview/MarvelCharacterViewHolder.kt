package dev.tsnanh.android.feature.dashboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import dev.tsnanh.android.domain.util.MarvelImageVariants
import dev.tsnanh.android.domain.util.url
import dev.tsnanh.android.feature.dashboard.databinding.ItemMarvelCharacterBinding
import dev.tsnanh.core.models.MarvelCharacter

internal class MarvelCharacterViewHolder private constructor(
    private val binding: ItemMarvelCharacterBinding,
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): MarvelCharacterViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemMarvelCharacterBinding.inflate(inflater, parent, false)

            return MarvelCharacterViewHolder(binding)
        }
    }

    fun bind(character: MarvelCharacter?) {
        if (character == null) return
        binding.imageCharacter.load(character.thumbnail.url(type = MarvelImageVariants.Portrait.Incredible)) {
            diskCachePolicy(CachePolicy.ENABLED)
        }
    }
}
