package dev.tsnanh.android.core.network.interceptors

import dev.tsnanh.android.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import org.apache.commons.codec.digest.DigestUtils
import javax.inject.Inject

internal class MarvelApiAuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val timestamp = System.currentTimeMillis()

        val seed = "${timestamp}${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}"
        val hash = DigestUtils.md5Hex(seed)

        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY)
            .addQueryParameter(HASH, hash)
            .addQueryParameter(TIMESTAMP, timestamp.toString()).build()

        return chain.proceed(
            request.newBuilder()
                .url(url)
                .build()
        )
    }

    companion object {
        private const val API_KEY = "apikey"
        private const val HASH = "hash"
        private const val TIMESTAMP = "ts"
    }
}
