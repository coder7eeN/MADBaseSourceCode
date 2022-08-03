package dev.tsnanh.android.core.data.repositories

import dev.tsnanh.core.models.CharacterDataWrapper

interface MarvelCharacterRepository {
    suspend fun getCharacters(limit: Int? = null, offset: Int? = null): CharacterDataWrapper
}
