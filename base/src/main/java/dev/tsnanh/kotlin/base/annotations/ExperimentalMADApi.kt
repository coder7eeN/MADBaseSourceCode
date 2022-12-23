package dev.tsnanh.kotlin.base.annotations

@RequiresOptIn
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ExperimentalMADApi
