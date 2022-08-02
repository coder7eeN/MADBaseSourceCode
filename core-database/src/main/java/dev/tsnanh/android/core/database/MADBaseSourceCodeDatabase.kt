package dev.tsnanh.android.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.tsnanh.android.core.database.daos.CharacterDao
import dev.tsnanh.android.core.database.entities.CharacterEntity
import dev.tsnanh.android.core.database.entities.ComicListEntity
import dev.tsnanh.android.core.database.entities.ComicSummaryEntity
import dev.tsnanh.android.core.database.entities.EventListEntity
import dev.tsnanh.android.core.database.entities.EventSummaryEntity
import dev.tsnanh.android.core.database.entities.ImageEntity
import dev.tsnanh.android.core.database.entities.SeriesListEntity
import dev.tsnanh.android.core.database.entities.SeriesSummaryEntity
import dev.tsnanh.android.core.database.entities.StoryListEntity
import dev.tsnanh.android.core.database.entities.StorySummaryEntity
import dev.tsnanh.android.core.database.entities.UrlEntity

@Database(
    entities = [
        CharacterEntity::class,
        ComicListEntity::class,
        ComicSummaryEntity::class,
        EventListEntity::class,
        EventSummaryEntity::class,
        ImageEntity::class,
        SeriesListEntity::class,
        SeriesSummaryEntity::class,
        StoryListEntity::class,
        StorySummaryEntity::class,
        UrlEntity::class,
    ],
    version = 1,
)
abstract class MADBaseSourceCodeDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDao
}
