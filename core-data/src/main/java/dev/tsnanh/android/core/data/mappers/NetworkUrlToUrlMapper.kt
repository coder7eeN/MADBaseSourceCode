package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.Url
import dev.tsnanh.android.core.network.models.NetworkUrl
import javax.inject.Inject

class NetworkUrlToUrlMapper @Inject constructor() : Mapper<NetworkUrl, Url> {
    override operator fun invoke(input: NetworkUrl): Url {
        return Url(
            type = input.type,
            url = input.url,
        )
    }
}
