package dev.tsnanh.android.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UrlEntity(
    val type: String,
    @PrimaryKey
    val url: String,
)
