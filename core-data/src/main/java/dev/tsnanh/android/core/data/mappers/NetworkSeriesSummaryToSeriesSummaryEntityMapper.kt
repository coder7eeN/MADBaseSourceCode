package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.SeriesSummaryEntity
import dev.tsnanh.android.core.network.models.NetworkSeriesSummary
import javax.inject.Inject

class NetworkSeriesSummaryToSeriesSummaryEntityMapper @Inject constructor() :
    Mapper<NetworkSeriesSummary, SeriesSummaryEntity> {
    override operator fun invoke(input: NetworkSeriesSummary): SeriesSummaryEntity {
        return SeriesSummaryEntity(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
