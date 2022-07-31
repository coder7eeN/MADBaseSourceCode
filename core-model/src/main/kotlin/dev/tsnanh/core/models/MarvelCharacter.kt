package dev.tsnanh.core.models

data class MarvelCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    val urls: List<Url>,
    val thumbnail: Image,
    val comics: ComicList,
    val stories: StoryList,
    val events: EventList,
    val series: SeriesList,
)
