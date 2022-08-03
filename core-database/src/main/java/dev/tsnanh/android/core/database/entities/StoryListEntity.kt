package dev.tsnanh.android.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoryListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "story_list_id")
    val id: Int? = null,
    @ColumnInfo(name = "story_available")
    val available: Int,
    @ColumnInfo(name = "story_returned")
    val returned: Int,
    @ColumnInfo(name = "story_collectionURI")
    val collectionURI: String,
)
