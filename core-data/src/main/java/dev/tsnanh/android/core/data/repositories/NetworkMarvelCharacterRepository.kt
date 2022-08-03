package dev.tsnanh.android.core.data.repositories

import dev.tsnanh.android.core.data.mappers.NetworkCharacterDataWrapperToCharacterDataWrapperMapper
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.di.MADDispatcher
import dev.tsnanh.android.core.network.di.MADDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class NetworkMarvelCharacterRepository @Inject constructor(
    private val marvelCharacterNetworkDataSource: MarvelCharacterNetworkDataSource,
    private val networkCharacterDataWrapperToCharacterDataWrapperMapper: NetworkCharacterDataWrapperToCharacterDataWrapperMapper,
    @MADDispatcher(MADDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : MarvelCharacterRepository {
    override suspend fun getCharacters(limit: Int?, offset: Int?) =
        withContext(dispatcher) {
            networkCharacterDataWrapperToCharacterDataWrapperMapper(
                marvelCharacterNetworkDataSource.getCharacters()
            )
        }
}
