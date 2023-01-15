package dev.tsnanh.android.core.network.delegate

import dev.tsnanh.android.core.network.base.Api
import dev.tsnanh.android.core.network.base.NetworkDataSource
import retrofit2.Retrofit
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal class ApiDelegate<A : Api>(
    private val retrofit: Retrofit,
    private val clazz: Class<A>,
    private val retrofitConfiguration: Retrofit.() -> Unit,
) : ReadOnlyProperty<NetworkDataSource, A> {
    override fun getValue(thisRef: NetworkDataSource, property: KProperty<*>): A =
        retrofit.apply(retrofitConfiguration).create(clazz)
}

internal inline fun <reified A> NetworkDataSource.createApi(noinline retrofitConfiguration: Retrofit.() -> Unit = {}) where A : Api =
    ApiDelegate(retrofit, A::class.java, retrofitConfiguration)
