package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.StoryListEntity
import dev.tsnanh.android.core.network.models.NetworkStoryList
import javax.inject.Inject

class NetworkStoryListToStoryListEntityMapper @Inject constructor() :
    Mapper<NetworkStoryList, StoryListEntity> {
    override fun invoke(input: NetworkStoryList): StoryListEntity {
        return StoryListEntity(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
        )
    }
}
