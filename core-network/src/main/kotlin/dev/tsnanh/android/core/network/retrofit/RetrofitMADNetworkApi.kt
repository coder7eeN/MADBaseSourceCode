package dev.tsnanh.android.core.network.retrofit

import retrofit2.http.GET

private const val BASE_URL = "https://gateway.marvel.com:443/v1/public"

private interface RetrofitMADNetworkApi {
    @GET(value = "/characters")
    suspend fun getCharacters(): List<>
}
