package dev.tsnanh.android.core.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    @Embedded
    val thumbnail: ImageEntity,
    @Embedded
    val comics: ComicListEntity,
    @Embedded
    val stories: StoryListEntity,
    @Embedded
    val events: EventListEntity,
    @Embedded
    val series: SeriesListEntity,
)
