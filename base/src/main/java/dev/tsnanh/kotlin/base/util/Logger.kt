package dev.tsnanh.kotlin.base.util

interface Logger {
    operator fun invoke(block: () -> Any?)

    fun i(message: String, vararg args: Any?)

    fun i(throwable: Throwable, message: String, vararg args: Any?)

    fun i(throwable: Throwable)

    fun w(message: String, vararg args: Any?)

    fun w(throwable: Throwable, message: String, vararg args: Any?)

    fun w(throwable: Throwable)

    fun d(message: String, vararg args: Any?)

    fun d(throwable: Throwable, message: String, vararg args: Any?)

    fun d(throwable: Throwable)

    fun e(message: String, vararg args: Any?)

    fun e(throwable: Throwable, message: String, vararg args: Any?)

    fun e(throwable: Throwable)

    fun v(message: String, vararg args: Any?)

    fun v(throwable: Throwable, message: String, vararg args: Any?)

    fun v(throwable: Throwable)

    fun wtf(message: String, vararg args: Any?)

    fun wtf(throwable: Throwable, message: String, vararg args: Any?)

    fun wtf(throwable: Throwable)
}
