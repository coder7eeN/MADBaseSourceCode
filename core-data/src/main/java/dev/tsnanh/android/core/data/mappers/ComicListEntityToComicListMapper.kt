package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ComicListEntity
import dev.tsnanh.core.models.ComicList
import javax.inject.Inject

class ComicListEntityToComicListMapper @Inject constructor(
    private val comicSummaryEntityToComicSummaryMapper: ComicSummaryEntityToComicSummaryMapper
) : Mapper<ComicListEntity, ComicList> {
    override operator fun invoke(input: ComicListEntity): ComicList {
        return ComicList(
            available = input.available,
            returned = input.returned,
            collectionURI = input.collectionURI,
            items = comicSummaryEntityToComicSummaryMapper.forList(emptyList())
        )
    }
}
