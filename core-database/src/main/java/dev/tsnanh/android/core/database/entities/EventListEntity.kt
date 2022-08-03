package dev.tsnanh.android.core.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_list_id")
    val id: Int? = null,
    @ColumnInfo(name = "event_available")
    val available: Int,
    @ColumnInfo(name = "event_returned")
    val returned: Int,
    @ColumnInfo(name = "event_collectionURI")
    val collectionURI: String,
)
