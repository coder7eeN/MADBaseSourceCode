package dev.tsnanh.android.core.common.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

enum class MADDispatchers {
    Main,
    IO,
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MADDispatcher(val dispatcher: MADDispatchers)

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @MADDispatcher(MADDispatchers.IO)
    @Provides
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MADDispatcher(MADDispatchers.Main)
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
