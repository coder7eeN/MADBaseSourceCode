package dev.tsnanh.android.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.tsnanh.android.core.network.BuildConfig
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Inject

private interface RetrofitMarvelCharacterNetworkApi {
    @GET(value = "characters")
    suspend fun getCharacters(): NetworkCharacterDataWrapper
}

internal class RetrofitMarvelCharacterNetwork @Inject constructor(
    okHttpClient: OkHttpClient,
    networkJson: Json,
) : MarvelCharacterNetworkDataSource {
    private val marvelCharacterNetworkApi: RetrofitMarvelCharacterNetworkApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create()

    override suspend fun getCharacters() = marvelCharacterNetworkApi.getCharacters()
}
