package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.StoryList
import dev.tsnanh.android.core.network.models.NetworkStoryList
import javax.inject.Inject

class NetworkStoryListToStoryListMapper @Inject constructor(
    private val networkStorySummaryToStorySummaryMapper: NetworkStorySummaryToStorySummaryMapper,
) : Mapper<NetworkStoryList, StoryList> {
    override fun invoke(input: NetworkStoryList): StoryList {
        return StoryList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = networkStorySummaryToStorySummaryMapper.forList(input.items),
        )
    }
}
