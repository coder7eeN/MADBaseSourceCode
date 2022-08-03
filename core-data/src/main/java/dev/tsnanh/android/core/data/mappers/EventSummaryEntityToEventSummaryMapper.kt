package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.EventSummaryEntity
import dev.tsnanh.core.models.EventSummary
import javax.inject.Inject

class EventSummaryEntityToEventSummaryMapper @Inject constructor() :
    Mapper<EventSummaryEntity, EventSummary> {
    override fun invoke(input: EventSummaryEntity): EventSummary {
        return EventSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
