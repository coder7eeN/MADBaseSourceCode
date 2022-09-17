package dev.tsnanh.android.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urls: List<NetworkUrl>,
    val thumbnail: NetworkImage,
    val comics: NetworkComicList,
    val stories: NetworkStoryList,
    val events: NetworkEventList,
    val series: NetworkSeriesList,
)
