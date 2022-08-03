package dev.tsnanh.android.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComicListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "comic_list_id")
    val id: Int? = null,
    @ColumnInfo(name = "comic_available")
    val available: Int,
    @ColumnInfo(name = "comic_returned")
    val returned: Int,
    @ColumnInfo(name = "comic_collectionURI")
    val collectionURI: String,
)
