package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ImageEntity
import dev.tsnanh.android.core.network.models.NetworkImage
import javax.inject.Inject

class NetworkImageToImageEntityMapper @Inject constructor() : Mapper<NetworkImage, ImageEntity> {
    override fun invoke(input: NetworkImage): ImageEntity {
        return ImageEntity(
            path = input.path,
            extension = input.extension,
        )
    }
}
