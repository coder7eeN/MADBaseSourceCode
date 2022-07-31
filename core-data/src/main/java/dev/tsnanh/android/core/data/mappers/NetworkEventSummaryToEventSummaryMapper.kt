package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.EventSummary
import dev.tsnanh.android.core.network.models.NetworkEventSummary
import javax.inject.Inject

class NetworkEventSummaryToEventSummaryMapper @Inject constructor() :
    Mapper<NetworkEventSummary, EventSummary> {
    override fun invoke(input: NetworkEventSummary): EventSummary {
        return EventSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
