package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkStorySummary(
    val resourceURI: String,
    val name: String,
    val type: String,
)
