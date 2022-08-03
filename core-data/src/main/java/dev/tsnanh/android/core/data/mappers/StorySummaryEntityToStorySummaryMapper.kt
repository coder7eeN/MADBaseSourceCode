package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.StorySummaryEntity
import dev.tsnanh.core.models.StorySummary
import javax.inject.Inject

class StorySummaryEntityToStorySummaryMapper @Inject constructor() :
    Mapper<StorySummaryEntity, StorySummary> {
    override fun invoke(input: StorySummaryEntity): StorySummary {
        return StorySummary(
            resourceURI = input.resourceURI,
            name = input.name,
            type = input.type,
        )
    }
}
