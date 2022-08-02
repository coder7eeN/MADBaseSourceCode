package dev.tsnanh.android.core.data.remotemediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import dev.tsnanh.android.core.database.entities.CharacterEntity

@OptIn(ExperimentalPagingApi::class)
internal class CharacterRemoteMediator : RemoteMediator<Int, CharacterEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {

    }
}
