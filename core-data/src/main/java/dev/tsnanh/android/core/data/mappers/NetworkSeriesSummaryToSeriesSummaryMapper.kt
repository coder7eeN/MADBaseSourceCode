package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.SeriesSummary
import dev.tsnanh.android.core.network.models.NetworkSeriesSummary
import javax.inject.Inject

class NetworkSeriesSummaryToSeriesSummaryMapper @Inject constructor() :
    Mapper<NetworkSeriesSummary, SeriesSummary> {
    override operator fun invoke(input: NetworkSeriesSummary): SeriesSummary {
        return SeriesSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
