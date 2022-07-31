package dev.tsnanh.android.core.data.mappers

import dev.tsnanh.core.models.CharacterDataContainer
import dev.tsnanh.android.core.network.models.NetworkCharacterDataContainer
import javax.inject.Inject

class NetworkCharacterDataContainerToCharacterDataContainerMapper @Inject constructor(
    private val networkCharacterToCharacterMapper: NetworkCharacterToCharacterMapper
) : Mapper<NetworkCharacterDataContainer, CharacterDataContainer> {
    override fun invoke(input: NetworkCharacterDataContainer): CharacterDataContainer {
        return CharacterDataContainer(
            offset = input.offset,
            limit = input.limit,
            total = input.total,
            count = input.count,
            results = networkCharacterToCharacterMapper.forList(input.results),
        )
    }
}
