package dev.tsnanh.core.models

data class SeriesList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<SeriesSummary>
)
