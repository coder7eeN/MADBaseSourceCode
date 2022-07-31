package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkComicList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<NetworkComicSummary>
)
