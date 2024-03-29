package dev.tsnanh.core.models

data class StoryList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<StorySummary>
)
