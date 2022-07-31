package dev.tsnanh.android.core.data.mappers

fun interface Mapper<in I, out O> {
    operator fun invoke(input: I): O
}
