package dev.tsnanh.android.core.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class EventListWithEventSummaryEntity(
    @Embedded
    val eventListEntity: EventListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "eventListEntityId"
    )
    val eventSummaries: List<EventSummaryEntity>
)
