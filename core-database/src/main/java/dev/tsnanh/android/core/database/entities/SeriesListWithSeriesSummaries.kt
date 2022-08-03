package dev.tsnanh.android.core.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class SeriesListWithSeriesSummaries(
    @Embedded val seriesList: SeriesListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "seriesListEntityId"
    )
    val seriesSummaries: List<SeriesSummaryEntity>
)
