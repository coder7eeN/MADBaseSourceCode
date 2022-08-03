package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ComicSummaryEntity
import dev.tsnanh.android.core.network.models.NetworkComicSummary
import javax.inject.Inject

class NetworkComicSummaryToComicSummeryEntityMapper @Inject constructor() :
    Mapper<NetworkComicSummary, ComicSummaryEntity> {
    override fun invoke(input: NetworkComicSummary): ComicSummaryEntity {
        return ComicSummaryEntity(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
