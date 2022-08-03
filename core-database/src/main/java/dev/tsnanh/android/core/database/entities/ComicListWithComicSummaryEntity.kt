package dev.tsnanh.android.core.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ComicListWithComicSummaryEntity(
    @Embedded val comicListEntity: ComicListEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "comicListEntityId"
    )
    val comicSummaryEntities: List<ComicSummaryEntity>
)
