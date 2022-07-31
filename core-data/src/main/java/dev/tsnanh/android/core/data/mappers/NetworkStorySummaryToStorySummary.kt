package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.StorySummary
import dev.tsnanh.android.core.network.models.NetworkStorySummary
import javax.inject.Inject

class NetworkStorySummaryToStorySummary @Inject constructor() :
    Mapper<NetworkStorySummary, StorySummary> {
    override fun invoke(input: NetworkStorySummary): StorySummary {
        return StorySummary(
            resourceURI = input.resourceURI,
            name = input.name,
            type = input.type,
        )
    }
}
