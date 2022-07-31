package dev.tsnanh.core.models

data class CharacterDataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<MarvelCharacter>,
)
