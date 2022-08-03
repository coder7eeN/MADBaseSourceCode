package dev.tsnanh.android.core.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class StoryListWithStorySummaries(
    @Embedded val storyList: StoryListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "storyListEntityId"
    )
    val storySummaries: List<StorySummaryEntity>
)
