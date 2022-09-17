package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkEventList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<NetworkEventSummary>,
)
