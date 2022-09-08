package dev.tsnanh.kotlin.base

sealed interface InvokeStatus<out T> {
    data class Success<T>(val data: T) : InvokeStatus<T>
    data class Error(val exception: Throwable? = null) : InvokeStatus<Nothing>
    object Started : InvokeStatus<Nothing>
}
