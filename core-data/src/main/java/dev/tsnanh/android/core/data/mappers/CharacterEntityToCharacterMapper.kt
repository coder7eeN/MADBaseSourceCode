package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.CharacterEntity
import dev.tsnanh.core.models.MarvelCharacter
import javax.inject.Inject

class CharacterEntityToCharacterMapper @Inject constructor(
    private val networkImageToImageMapper: ImageEntityToImageMapper,
    private val networkComicListToComicListMapper: ComicListEntityToComicListMapper,
    private val networkStoryListToStoryListMapper: StoryListEntityToStoryListMapper,
    private val networkEventListToEventListMapper: EventListEntityToEventListMapper,
    private val networkSeriesListToSeriesListMapper: SeriesListEntityToSeriesListMapper,
) : Mapper<CharacterEntity, MarvelCharacter> {
    override operator fun invoke(input: CharacterEntity): MarvelCharacter {
        return MarvelCharacter(
            id = input.id,
            name = input.name,
            description = input.description,
            modified = input.modified,
            resourceURI = input.resourceURI,
            urls = emptyList(),
            thumbnail = networkImageToImageMapper(input.thumbnail),
            comics = networkComicListToComicListMapper(input.comics),
            stories = networkStoryListToStoryListMapper(input.stories),
            events = networkEventListToEventListMapper(input.events),
            series = networkSeriesListToSeriesListMapper(input.series)
        )
    }
}
