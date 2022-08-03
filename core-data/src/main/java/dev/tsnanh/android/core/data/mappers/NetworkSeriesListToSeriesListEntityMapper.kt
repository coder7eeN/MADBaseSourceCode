package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.SeriesListEntity
import dev.tsnanh.android.core.network.models.NetworkSeriesList
import javax.inject.Inject

class NetworkSeriesListToSeriesListEntityMapper @Inject constructor() :
    Mapper<NetworkSeriesList, SeriesListEntity> {
    override fun invoke(input: NetworkSeriesList): SeriesListEntity {
        return SeriesListEntity(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
        )
    }
}
