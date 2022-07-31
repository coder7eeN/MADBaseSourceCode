package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.SeriesList
import dev.tsnanh.android.core.network.models.NetworkSeriesList
import javax.inject.Inject

class NetworkSeriesListToSeriesListMapper @Inject constructor(
    private val networkSeriesSummaryToSeriesSummaryMapper: NetworkSeriesSummaryToSeriesSummaryMapper
) : Mapper<NetworkSeriesList, SeriesList> {
    override fun invoke(input: NetworkSeriesList): SeriesList {
        return SeriesList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkSeriesSummaryToSeriesSummaryMapper.forList(input.items)
        )
    }
}
