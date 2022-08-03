package dev.tsnanh.android.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "series_list_id")
    val id: Int? = null,
    @ColumnInfo(name = "series_available")
    val available: Int,
    @ColumnInfo(name = "series_returned")
    val returned: Int,
    @ColumnInfo(name = "series_collectionURI")
    val collectionURI: String,
)
