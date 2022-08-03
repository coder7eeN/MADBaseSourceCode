package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.EventListEntity
import dev.tsnanh.android.core.network.models.NetworkEventList
import javax.inject.Inject

class NetworkEventListToEventListEntityMapper @Inject constructor() :
    Mapper<NetworkEventList, EventListEntity> {
    override fun invoke(input: NetworkEventList): EventListEntity {
        return EventListEntity(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
        )
    }
}
