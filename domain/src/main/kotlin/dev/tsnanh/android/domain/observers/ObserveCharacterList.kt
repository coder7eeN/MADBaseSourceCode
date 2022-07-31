package dev.tsnanh.android.domain.observers

import dev.tsnanh.core.models.CharacterDataWrapper
import dev.tsnanh.android.core.data.repositories.MarvelCharacterRepository
import dev.tsnanh.android.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ObserveCharacterList @Inject constructor(
    private val marvelCharacterRepository: MarvelCharacterRepository
) : SubjectInteractor<Unit, CharacterDataWrapper>() {
    override fun createObservable(params: Unit): Flow<CharacterDataWrapper> {
        return flow { emit(marvelCharacterRepository.getCharacters()) }
    }
}
