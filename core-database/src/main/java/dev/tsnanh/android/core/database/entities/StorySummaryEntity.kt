package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StorySummaryEntity(
    @PrimaryKey
    val resourceURI: String,
    val name: String,
    val type: String,
    val storyListEntityId: Int? = null,
)
