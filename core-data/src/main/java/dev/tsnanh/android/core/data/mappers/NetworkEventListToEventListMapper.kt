package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.EventList
import dev.tsnanh.android.core.network.models.NetworkEventList
import javax.inject.Inject

class NetworkEventListToEventListMapper @Inject constructor(
    private val networkEventSummaryToEventSummaryMapper: NetworkEventSummaryToEventSummaryMapper
) : Mapper<NetworkEventList, EventList> {
    override fun invoke(input: NetworkEventList): EventList {
        return EventList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkEventSummaryToEventSummaryMapper.forList(input.items)
        )
    }
}
