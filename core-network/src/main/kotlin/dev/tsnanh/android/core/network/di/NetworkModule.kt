package dev.tsnanh.android.core.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.network.NetworkConstants
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.interceptors.MarvelApiAuthInterceptor
import dev.tsnanh.android.core.network.retrofit.RetrofitMarvelCharacterNetwork
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        @Provides
        internal fun providesOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            marvelApiAuthInterceptor: MarvelApiAuthInterceptor,
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(marvelApiAuthInterceptor)
                .connectTimeout(NetworkConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build()

        @Provides
        fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
    }

    @Binds
    internal abstract fun bindsMarvelCharacterDataSource(
        retrofitMarvelCharacterNetwork: RetrofitMarvelCharacterNetwork
    ): MarvelCharacterNetworkDataSource
}
