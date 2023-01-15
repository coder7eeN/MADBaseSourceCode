package dev.tsnanh.android.core.network.datasources

import dev.tsnanh.android.core.network.base.NetworkDataSource
import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper

interface MarvelCharacterNetworkDataSource : NetworkDataSource {
    suspend fun getCharacters(): NetworkCharacterDataWrapper
}
