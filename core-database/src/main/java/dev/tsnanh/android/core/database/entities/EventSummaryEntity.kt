package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventSummaryEntity(
    @PrimaryKey
    val resourceURI: String,
    val name: String,
    val eventListEntityId: Int? = null,
)
