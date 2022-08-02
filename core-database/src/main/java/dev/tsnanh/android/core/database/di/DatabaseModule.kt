package dev.tsnanh.android.core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.database.MADBaseSourceCodeDatabase
import dev.tsnanh.android.core.database.daos.CharacterDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesMADBaseSourceCodeDatabase(context: Context): MADBaseSourceCodeDatabase =
        Room.databaseBuilder(
            context,
            MADBaseSourceCodeDatabase::class.java,
            "mad_database"
        ).build()

    @Provides
    @Singleton
    fun providesCharacterDao(madBaseSourceCodeDatabase: MADBaseSourceCodeDatabase): CharacterDao =
        madBaseSourceCodeDatabase.characterDao
}
