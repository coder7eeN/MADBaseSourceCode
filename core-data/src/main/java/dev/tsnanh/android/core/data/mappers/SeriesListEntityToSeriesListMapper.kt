package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.SeriesListEntity
import dev.tsnanh.core.models.SeriesList
import javax.inject.Inject

class SeriesListEntityToSeriesListMapper @Inject constructor(
    private val networkSeriesSummaryToSeriesSummaryMapper: SeriesSummaryEntityToSeriesSummaryMapper
) : Mapper<SeriesListEntity, SeriesList> {
    override fun invoke(input: SeriesListEntity): SeriesList {
        return SeriesList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkSeriesSummaryToSeriesSummaryMapper.forList(emptyList())
        )
    }
}
