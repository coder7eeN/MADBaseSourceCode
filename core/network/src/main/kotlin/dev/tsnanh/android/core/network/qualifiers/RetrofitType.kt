package dev.tsnanh.android.core.network.qualifiers

import javax.inject.Qualifier

enum class RetrofitTypes {
    NoAuth, Auth,
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class RetrofitType(val retrofitType: RetrofitTypes)
