package dev.tsnanh.android.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.data.repositories.MarvelCharacterRepository
import dev.tsnanh.android.core.data.repositories.NetworkMarvelCharacterRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {
    @Binds
    abstract fun bindsMarvelCharacterRepository(
        networkMarvelCharacterRepository: NetworkMarvelCharacterRepository
    ): MarvelCharacterRepository
}
