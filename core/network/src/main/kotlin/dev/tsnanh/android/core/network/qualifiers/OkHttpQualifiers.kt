package dev.tsnanh.android.core.network.qualifiers

import javax.inject.Qualifier

enum class OkHttpClients {
    NoAuth, Auth,
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class OkHttpClientType(val okHttpClient: OkHttpClients)
