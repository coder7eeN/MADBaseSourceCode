package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.SeriesSummaryEntity
import dev.tsnanh.core.models.SeriesSummary
import javax.inject.Inject

class SeriesSummaryEntityToSeriesSummaryMapper @Inject constructor() :
    Mapper<SeriesSummaryEntity, SeriesSummary> {
    override operator fun invoke(input: SeriesSummaryEntity): SeriesSummary {
        return SeriesSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
