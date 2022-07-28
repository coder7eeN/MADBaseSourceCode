package dev.tsnanh.android.base.logger

import dev.tsnanh.kotlin.base.util.Logger
import timber.log.Timber
import javax.inject.Inject

internal class TimberLogger @Inject constructor() : Logger {
    override fun i(message: String, vararg args: Any?) {
        Timber.i(message, args)
    }

    override fun i(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.i(throwable, message, args)
    }

    override fun i(throwable: Throwable) {
        Timber.i(throwable)
    }

    override fun w(message: String, vararg args: Any?) {
        Timber.w(message, args)
    }

    override fun w(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.w(throwable, message, args)
    }

    override fun w(throwable: Throwable) {
        Timber.w(throwable)
    }

    override fun d(message: String, vararg args: Any?) {
        Timber.d(message, args)
    }

    override fun d(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.d(throwable, message, args)
    }

    override fun d(throwable: Throwable) {
        Timber.d(throwable)
    }

    override fun e(message: String, vararg args: Any?) {
        Timber.e(message, args)
    }

    override fun e(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.e(throwable, message, args)
    }

    override fun e(throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun v(message: String, vararg args: Any?) {
        Timber.v(message, args)
    }

    override fun v(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.v(throwable, message, args)
    }

    override fun v(throwable: Throwable) {
        Timber.v(throwable)
    }

    override fun wtf(message: String, vararg args: Any?) {
        Timber.wtf(message, args)
    }

    override fun wtf(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.wtf(throwable, message, args)
    }

    override fun wtf(throwable: Throwable) {
        Timber.wtf(throwable)
    }

    override fun clgt(message: String, vararg args: Any?) {
        Timber.wtf(message, args)
    }

    override fun clgt(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.wtf(throwable, message, args)
    }

    override fun clgt(throwable: Throwable) {
        Timber.wtf(throwable)
    }

    override fun dkmvclvltn(message: String, vararg args: Any?) {
        Timber.wtf(message, args)
    }

    override fun dkmvclvltn(throwable: Throwable, message: String, vararg args: Any?) {
        Timber.wtf(throwable, message, args)
    }

    override fun dkmvclvltn(throwable: Throwable) {
        Timber.wtf(throwable)
    }
}
