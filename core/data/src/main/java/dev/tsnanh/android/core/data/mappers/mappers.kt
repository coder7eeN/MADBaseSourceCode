package dev.tsnanh.android.core.data.mappers

inline val <I, O> Mapper<I, O>.forList: (List<I>) -> List<O> get() = { list -> list.map { invoke(it) } }
