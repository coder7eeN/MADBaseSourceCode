package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.StoryListEntity
import dev.tsnanh.core.models.StoryList
import javax.inject.Inject

class StoryListEntityToStoryListMapper @Inject constructor(
    private val networkStorySummaryToStorySummary: StorySummaryEntityToStorySummaryMapper,
) : Mapper<StoryListEntity, StoryList> {
    override fun invoke(input: StoryListEntity): StoryList {
        return StoryList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkStorySummaryToStorySummary.forList(emptyList()),
        )
    }
}
