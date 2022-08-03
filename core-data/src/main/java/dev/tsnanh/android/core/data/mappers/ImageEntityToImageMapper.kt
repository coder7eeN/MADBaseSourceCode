package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.android.core.database.entities.ImageEntity
import dev.tsnanh.core.models.Image
import javax.inject.Inject

class ImageEntityToImageMapper @Inject constructor() : Mapper<ImageEntity, Image> {
    override operator fun invoke(input: ImageEntity): Image {
        return Image(
            path = input.path,
            extension = input.extension,
        )
    }
}
