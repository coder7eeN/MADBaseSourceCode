package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkComicSummary(
    val resourceURI: String,
    val name: String,
)
