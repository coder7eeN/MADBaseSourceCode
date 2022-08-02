package dev.tsnanh.android.core.database.entities

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
    val urls: List<UrlEntity>,
    val thumbnail: ImageEntity,
    val comics: ComicListEntity,
    val stories: StoryListEntity,
    val events: EventListEntity,
    val series: SeriesListEntity,
)
