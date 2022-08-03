package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesSummaryEntity(
    @PrimaryKey
    val resourceURI: String,
    val name: String,
    val seriesListEntityId: Int? = null,
)