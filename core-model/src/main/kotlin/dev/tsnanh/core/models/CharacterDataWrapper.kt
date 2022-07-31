package dev.tsnanh.core.models

import dev.tsnanh.core.models.CharacterDataContainer

data class CharacterDataWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: CharacterDataContainer,
    val etag: String? = null,
)
