package dev.tsnanh.android.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.tsnanh.android.core.network.AuthenticationInterceptor
import dev.tsnanh.android.core.network.BuildConfig
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.qualifiers.OkHttpClientType
import dev.tsnanh.android.core.network.qualifiers.OkHttpClients
import dev.tsnanh.android.core.network.qualifiers.RetrofitType
import dev.tsnanh.android.core.network.qualifiers.RetrofitTypes
import dev.tsnanh.android.core.network.retrofit.RetrofitMarvelCharacterNetwork
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface NetworkModule {
    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        // @Provides
        // @Singleton
        // fun providesNetworkCache

        @Provides
        @Singleton
        @OkHttpClientType(OkHttpClients.NoAuth)
        fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        @Provides
        @Singleton
        @OkHttpClientType(OkHttpClients.Auth)
        fun providesOkHttpClientWithAuthInterceptor(
            httpLoggingInterceptor: HttpLoggingInterceptor,
            authenticationInterceptor: AuthenticationInterceptor,
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authenticationInterceptor)
                .build()

        @Provides
        @Singleton
        fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }

        @Provides
        @Singleton
        @RetrofitType(RetrofitTypes.Auth)
        fun providesRetrofitAuthApi(
            @OkHttpClientType(OkHttpClients.Auth) okHttpClient: OkHttpClient,
            networkJson: Json,
        ): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
                .baseUrl(BuildConfig.BASE_URL)
                .build()

        @Provides
        @Singleton
        @RetrofitType(RetrofitTypes.NoAuth)
        fun providesRetrofitApi(
            @OkHttpClientType(OkHttpClients.NoAuth) okHttpClient: OkHttpClient,
            networkJson: Json,
        ): Retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
                .baseUrl(BuildConfig.BASE_URL)
                .build()
    }

    @Binds
    @Singleton
    fun bindsMarvelCharacterDataSource(
        retrofitMarvelCharacterNetwork: RetrofitMarvelCharacterNetwork,
    ): MarvelCharacterNetworkDataSource
}
