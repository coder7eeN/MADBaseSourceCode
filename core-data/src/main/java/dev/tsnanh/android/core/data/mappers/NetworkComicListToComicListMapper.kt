package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.ComicList
import dev.tsnanh.android.core.network.models.NetworkComicList
import javax.inject.Inject

class NetworkComicListToComicListMapper @Inject constructor(
    private val networkComicSummaryToComicSummaryMapper: NetworkComicSummaryToComicSummaryMapper
) : Mapper<NetworkComicList, ComicList> {
    override operator fun invoke(input: NetworkComicList): ComicList {
        return ComicList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkComicSummaryToComicSummaryMapper.forList(input.items)
        )
    }
}
