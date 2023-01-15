package dev.tsnanh.android.core.network.retrofit

import dev.tsnanh.android.core.network.BuildConfig
import dev.tsnanh.android.core.network.base.Api
import dev.tsnanh.android.core.network.datasources.MarvelCharacterNetworkDataSource
import dev.tsnanh.android.core.network.delegate.createApi
import dev.tsnanh.android.core.network.endpoints.Endpoint
import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper
import dev.tsnanh.android.core.network.qualifiers.OkHttpClientType
import dev.tsnanh.android.core.network.qualifiers.OkHttpClients
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

private interface RetrofitMarvelCharacterNetworkApi : Api {
    @GET(value = Endpoint.Characters.characters)
    suspend fun getCharacters(
        @Query(Endpoint.Characters.GET.qApiKey) apiKey: String,
        @Query(Endpoint.Characters.GET.qTimestamp) timestamp: String,
    ): NetworkCharacterDataWrapper
}

internal class RetrofitMarvelCharacterNetwork @Inject constructor(
    @OkHttpClientType(OkHttpClients.NoAuth)
    override val retrofit: Retrofit
) : MarvelCharacterNetworkDataSource {
    private val api by createApi<RetrofitMarvelCharacterNetworkApi>()
    override suspend fun getCharacters() = api.getCharacters(BuildConfig.API_KEY, "1659268624184")
}
