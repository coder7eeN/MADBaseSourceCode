package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.CharacterDataWrapper
import dev.tsnanh.android.core.network.models.NetworkCharacterDataWrapper
import javax.inject.Inject

class NetworkCharacterDataWrapperToCharacterDataWrapperMapper @Inject constructor(
    private val networkCharacterDataContainerToCharacterDataContainerMapper: NetworkCharacterDataContainerToCharacterDataContainerMapper
) : Mapper<NetworkCharacterDataWrapper, CharacterDataWrapper> {
    override fun invoke(input: NetworkCharacterDataWrapper): CharacterDataWrapper {
        return CharacterDataWrapper(
            code = input.code,
            status = input.status,
            copyright = input.copyright,
            attributionText = input.attributionText,
            attributionHTML = input.attributionHTML,
            data = networkCharacterDataContainerToCharacterDataContainerMapper(input.data),
            etag = input.etag,
        )
    }
}
