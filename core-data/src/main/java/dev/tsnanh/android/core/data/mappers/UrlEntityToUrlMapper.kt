package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.UrlEntity
import dev.tsnanh.core.models.Url
import javax.inject.Inject

class UrlEntityToUrlMapper @Inject constructor() : Mapper<UrlEntity, Url> {
    override operator fun invoke(input: UrlEntity): Url {
        return Url(
            type = input.type,
            url = input.url,
        )
    }
}
