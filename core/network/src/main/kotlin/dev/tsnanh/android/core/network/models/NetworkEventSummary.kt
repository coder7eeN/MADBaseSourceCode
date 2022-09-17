package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkEventSummary(
    val resourceURI: String,
    val name: String,
)
