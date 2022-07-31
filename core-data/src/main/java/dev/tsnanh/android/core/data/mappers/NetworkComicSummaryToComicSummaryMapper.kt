package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.ComicSummary
import dev.tsnanh.android.core.network.models.NetworkComicSummary
import javax.inject.Inject

class NetworkComicSummaryToComicSummaryMapper @Inject constructor() :
    Mapper<NetworkComicSummary, ComicSummary> {
    override fun invoke(input: NetworkComicSummary): ComicSummary {
        return ComicSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
