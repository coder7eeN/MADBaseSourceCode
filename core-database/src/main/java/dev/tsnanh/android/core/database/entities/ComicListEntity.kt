package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComicListEntity(
    val available: Int,
    val returned: Int,
    @PrimaryKey
    val collectionURI: String,
    val items: List<ComicSummaryEntity>
)
