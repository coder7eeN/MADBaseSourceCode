package dev.tsnanh.android.base.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.base.logger.TimberLogger
import dev.tsnanh.kotlin.base.util.Logger
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BaseAndroidModule {
    @Singleton
    @Binds
    internal abstract fun bindsLogger(timberLogger: TimberLogger): Logger
}
