package dev.tsnanh.android.core.network.datasources

import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper

interface MarvelCharacterNetworkDataSource {
    suspend fun getCharacters(limit: Int? = null, offset: Int? = null): NetworkCharacterDataWrapper
}
