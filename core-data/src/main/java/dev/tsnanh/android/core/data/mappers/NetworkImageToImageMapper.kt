package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.Image
import dev.tsnanh.android.core.network.models.NetworkImage
import javax.inject.Inject

class NetworkImageToImageMapper @Inject constructor() : Mapper<NetworkImage, Image> {
    override operator fun invoke(input: NetworkImage): Image {
        return Image(
            path = input.path,
            extension = input.extension,
        )
    }
}
