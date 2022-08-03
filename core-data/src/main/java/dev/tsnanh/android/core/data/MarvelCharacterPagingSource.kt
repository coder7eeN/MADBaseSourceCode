package dev.tsnanh.android.core.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.tsnanh.android.core.data.mappers.NetworkCharacterToCharacterMapper
import dev.tsnanh.android.core.data.mappers.forList
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.core.models.MarvelCharacter
import javax.inject.Inject

class MarvelCharacterPagingSource @Inject constructor(
    private val marvelCharacterNetworkDataSource: MarvelCharacterNetworkDataSource,
    private val networkCharacterToCharacterMapper: NetworkCharacterToCharacterMapper
) : PagingSource<Int, MarvelCharacter>() {
    override fun getRefreshKey(state: PagingState<Int, MarvelCharacter>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelCharacter> {
        return try {
            val loadKey = params.key ?: 0

            val characters = marvelCharacterNetworkDataSource.getCharacters(
                limit = params.loadSize,
                offset = loadKey
            )

            LoadResult.Page(
                data = networkCharacterToCharacterMapper.forList(characters.data.results)
                    .filter { character ->
                        !character.thumbnail.path.contains("image_not_available")
                    },
                prevKey = null,
                nextKey = loadKey + params.loadSize
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
