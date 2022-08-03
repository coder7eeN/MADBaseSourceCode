package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.UrlEntity
import dev.tsnanh.android.core.network.models.NetworkUrl
import javax.inject.Inject

class NetworkUrlToUrlEntityMapper @Inject constructor() : Mapper<NetworkUrl, UrlEntity> {
    override fun invoke(input: NetworkUrl): UrlEntity {
        return UrlEntity(
            type = input.type,
            url = input.url,
        )
    }
}
