package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.EventSummaryEntity
import dev.tsnanh.android.core.network.models.NetworkEventSummary
import javax.inject.Inject

class NetworkEventSummaryToEventSummaryEntityMapper @Inject constructor() :
    Mapper<NetworkEventSummary, EventSummaryEntity> {
    override fun invoke(input: NetworkEventSummary): EventSummaryEntity {
        return EventSummaryEntity(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
