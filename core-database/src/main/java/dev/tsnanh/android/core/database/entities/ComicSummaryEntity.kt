package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComicSummaryEntity(
    @PrimaryKey
    val resourceURI: String,
    val name: String,
    val comicListEntityId: Int? = null,
)
