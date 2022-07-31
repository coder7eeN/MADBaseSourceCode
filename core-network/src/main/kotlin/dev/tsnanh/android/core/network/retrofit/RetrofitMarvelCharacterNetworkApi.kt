package dev.tsnanh.android.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper
import kotlinx.datetime.DateTimePeriod
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Inject

private const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"

private interface RetrofitMarvelCharacterNetworkApi {
    @GET(value = "characters?apikey=da6fdb4edc23dd68d0472b0838b4c8b1&hash=ae034a42ad44bc28635c5ed7fa688b60&ts=1659268624184")
    suspend fun getCharacters(): NetworkCharacterDataWrapper
}

class RetrofitMarvelCharacterNetwork @Inject constructor(
    okHttpClient: OkHttpClient,
    networkJson: Json,
) : MarvelCharacterNetworkDataSource {
    private val marvelCharacterNetworkApi: RetrofitMarvelCharacterNetworkApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
            .create()

    override suspend fun getCharacters() = marvelCharacterNetworkApi.getCharacters()
}
