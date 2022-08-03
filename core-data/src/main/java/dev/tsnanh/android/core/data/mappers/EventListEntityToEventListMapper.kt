package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.EventListEntity
import dev.tsnanh.core.models.EventList
import javax.inject.Inject

class EventListEntityToEventListMapper @Inject constructor(
    private val networkEventSummaryToEventSummaryMapper: EventSummaryEntityToEventSummaryMapper
) : Mapper<EventListEntity, EventList> {
    override fun invoke(input: EventListEntity): EventList {
        return EventList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkEventSummaryToEventSummaryMapper.forList(emptyList())
        )
    }
}
