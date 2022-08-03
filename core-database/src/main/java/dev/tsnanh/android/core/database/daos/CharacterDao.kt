package dev.tsnanh.android.core.database.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.tsnanh.android.core.database.entities.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character_table")
    fun getPagedCharacters(): PagingSource<Int, CharacterEntity>

    @Insert(entity = CharacterEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacters(vararg characters: CharacterEntity)

    @Query("DELETE FROM character_table")
    suspend fun deleteAllCharacters()
}
