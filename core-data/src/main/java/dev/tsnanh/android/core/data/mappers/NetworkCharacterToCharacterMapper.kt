package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.MarvelCharacter
import dev.tsnanh.android.core.network.models.NetworkCharacter
import javax.inject.Inject

class NetworkCharacterToCharacterMapper @Inject constructor(
    private val networkUrlToUrlMapper: NetworkUrlToUrlMapper,
    private val networkImageToImageMapper: NetworkImageToImageMapper,
    private val networkComicListToComicListMapper: NetworkComicListToComicListMapper,
    private val networkStoryListToStoryListMapper: NetworkStoryListToStoryListMapper,
    private val networkEventListToEventListMapper: NetworkEventListToEventListMapper,
    private val networkSeriesListToSeriesListMapper: NetworkSeriesListToSeriesListMapper,
) : Mapper<NetworkCharacter, MarvelCharacter> {
    override operator fun invoke(input: NetworkCharacter): MarvelCharacter {
        return MarvelCharacter(
            id = input.id,
            name = input.name,
            description = input.description,
            modified = input.modified,
            resourceURI = input.resourceURI,
            urls = networkUrlToUrlMapper.forList(input.urls),
            thumbnail = networkImageToImageMapper(input.thumbnail),
            comics = networkComicListToComicListMapper(input.comics),
            stories = networkStoryListToStoryListMapper(input.stories),
            events = networkEventListToEventListMapper(input.events),
            series = networkSeriesListToSeriesListMapper(input.series)
        )
    }
}
