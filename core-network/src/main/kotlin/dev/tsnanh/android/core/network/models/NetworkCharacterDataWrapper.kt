package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacterDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: NetworkCharacterDataContainer,
    val etag: String? = null,
)
