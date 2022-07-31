package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSeriesList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<NetworkSeriesSummary>
)
