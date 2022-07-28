package dev.tsnanh.android.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.tsnanh.kotlin.base.InvokeError
import dev.tsnanh.kotlin.base.InvokeStarted
import dev.tsnanh.kotlin.base.InvokeStatus
import dev.tsnanh.kotlin.base.InvokeSuccess
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

abstract class Interactor<in P> {
    operator fun invoke(
        params: P,
        timeoutMs: Long = defaultTimeoutMs
    ): Flow<InvokeStatus> = flow {
        try {
            withTimeout(timeoutMs) {
                emit(InvokeStarted)
                doWork(params)
                emit(InvokeSuccess)
            }
        } catch (timeOutException: TimeoutCancellationException) {
            emit(InvokeError(timeOutException))
        }
    }.catch { t -> emit(InvokeError(t)) }

    protected abstract suspend fun doWork(params: P)

    suspend fun executeSync(params: P) = doWork(params)

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }
}

abstract class ResultInteractor<in P, R> {
    operator fun invoke(params: P): Flow<R> = flow {
        emit(doWork(params))
    }

    protected abstract suspend fun doWork(params: P): R
}

abstract class SubjectInteractor<P : Any, T> {
    private val paramState = MutableSharedFlow<P>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    val flow: Flow<T> = paramState
        .distinctUntilChanged()
        .flatMapLatest { createObservable(it) }
        .distinctUntilChanged()

    abstract fun createObservable(params: P): Flow<T>

    operator fun invoke(params: P) {
        paramState.tryEmit(params)
    }
}

abstract class PagingInteractor<P : PagingInteractor.Parameter<T>, T : Any> :
    SubjectInteractor<P, PagingData<T>>() {
    interface Parameter<T : Any> {
        val pagingConfig: PagingConfig
    }
}

abstract class SuspendingWorkInteractor<P : Any, T> : SubjectInteractor<P, T>() {
    abstract fun doWork(params: P): T

    override fun createObservable(params: P) = flow { emit(doWork(params)) }
}
