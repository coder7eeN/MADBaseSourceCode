package dev.tsnanh.android.domain.observers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.tsnanh.android.core.data.MarvelCharacterPagingSource
import dev.tsnanh.android.domain.PagingInteractor
import dev.tsnanh.core.models.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObservePagedCharacterList @Inject constructor(
    private val marvelCharacterPagingSource: MarvelCharacterPagingSource
) : PagingInteractor<ObservePagedCharacterList.Params, MarvelCharacter>() {
    data class Params(
        override val pagingConfig: PagingConfig = PagingConfig(pageSize = 20)
    ) : Parameter<MarvelCharacter>

    override fun createObservable(params: Params): Flow<PagingData<MarvelCharacter>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = {
                marvelCharacterPagingSource
            }
        ).flow
    }

    private companion object {
        private const val IMAGE_NOT_FOUND = "image_not_found"
    }
}
