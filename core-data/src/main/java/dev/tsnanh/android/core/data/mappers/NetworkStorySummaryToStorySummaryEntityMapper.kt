package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.StorySummaryEntity
import dev.tsnanh.android.core.network.models.NetworkStorySummary
import javax.inject.Inject

class NetworkStorySummaryToStorySummaryEntityMapper @Inject constructor() :
    Mapper<NetworkStorySummary, StorySummaryEntity> {
    override fun invoke(input: NetworkStorySummary): StorySummaryEntity {
        return StorySummaryEntity(
            resourceURI = input.resourceURI,
            name = input.name,
            type = input.type,
        )
    }
}
