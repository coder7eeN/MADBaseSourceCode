package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSeriesSummary(
    val resourceURI: String,
    val name: String,
)
