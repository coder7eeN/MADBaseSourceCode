package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.CharacterEntity
import dev.tsnanh.android.core.network.models.NetworkCharacter
import javax.inject.Inject

class NetworkCharacterToCharacterEntityMapper @Inject constructor(
    private val networkImageToImageEntityMapper: NetworkImageToImageEntityMapper,
    private val networkComicListToComicListEntityMapper: NetworkComicListToComicListEntityMapper,
    private val networkStoryListToStoryListEntityMapper: NetworkStoryListToStoryListEntityMapper,
    private val networkEventListToEventListEntityMapper: NetworkEventListToEventListEntityMapper,
    private val networkSeriesListToSeriesListEntityMapper: NetworkSeriesListToSeriesListEntityMapper
) : Mapper<NetworkCharacter, CharacterEntity> {
    override fun invoke(input: NetworkCharacter): CharacterEntity {
        return CharacterEntity(
            id = input.id,
            name = input.name,
            description = input.description,
            modified = input.modified,
            resourceURI = input.resourceURI,
            thumbnail = networkImageToImageEntityMapper(input.thumbnail),
            comics = networkComicListToComicListEntityMapper(input.comics),
            stories = networkStoryListToStoryListEntityMapper(input.stories),
            events = networkEventListToEventListEntityMapper(input.events),
            series = networkSeriesListToSeriesListEntityMapper(input.series)
        )
    }
}
