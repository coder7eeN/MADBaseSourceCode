package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkUrl(
    val type: String,
    val url: String,
)
