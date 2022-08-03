package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ComicListEntity
import dev.tsnanh.android.core.network.models.NetworkComicList
import javax.inject.Inject

class NetworkComicListToComicListEntityMapper @Inject constructor() :
    Mapper<NetworkComicList, ComicListEntity> {
    override fun invoke(input: NetworkComicList): ComicListEntity {
        return ComicListEntity(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
        )
    }
}
