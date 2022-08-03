package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ComicSummaryEntity
import dev.tsnanh.core.models.ComicSummary
import javax.inject.Inject

class ComicSummaryEntityToComicSummaryMapper @Inject constructor() :
    Mapper<ComicSummaryEntity, ComicSummary> {
    override fun invoke(input: ComicSummaryEntity): ComicSummary {
        return ComicSummary(
            resourceURI = input.resourceURI,
            name = input.name,
        )
    }
}
