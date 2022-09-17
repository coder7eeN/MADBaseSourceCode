package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkImage(
    val path: String,
    val extension: String,
)
