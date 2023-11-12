/*
 * kotlin-use - AutoCloseable utilities for Kotlin
 *
 * https://github.com/DenWav/kotlin-use
 *
 * Copyright (C) 2023 Kyle Wood (DenWav)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, version 3.0 only.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.denwav.use

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Executes the given [block] function, running any registered [deferred actions][Defer.defer] upon completion. All
 * deferred actions are guaranteed to execute, whether an exception is thrown or not. This provides functionality like
 * the `defer` keyword in Swift or Go.
 *
 * The primary use-case for a deferring block is as an alternative to [use] or [using] for more complex situations. For
 * these instances, the [Defer.deferClose] extension function provides a convenient way to register closing an
 * [AutoCloseable] resource as a deferred action.
 *
 * Deferred actions are executed in the reverse order they are registered, in a first-in-last-out manner. To put it
 * another way, the first deferred action registered will be the last to execute.
 *
 * If an exception is thrown during execution of [block], and a deferred action throws an exception as well, the latter
 * exception is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * @param block a function to execute, with any deferred actions registered executed upon completion.
 * @return the result of [block] function, after all deferred actions have completed.
 * @see deferrableCatching
 * @see using
 * @see use
 */
inline fun <R> deferrable(block: Defer.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val defer = Defer()
    var thrown: Throwable? = null
    var result: R? = null
    try {
        result = block(defer)
    } catch (t: Throwable) {
        thrown = t
    } finally {
        thrown = defer.runDeferred(thrown)
    }
    thrown?.let { throw it }
    return result!!
}

/**
 * Executes the given [block] function, running any registered [deferred actions][Defer.defer] upon completion. All
 * deferred actions are guaranteed to execute, whether an exception is thrown or not. This provides functionality like
 * the `defer` keyword in Swift or Go.
 *
 * The result is wrapped in a [Result] and returned, this will never throw an exception.
 *
 * The primary use-case for a deferring block is as an alternative to [use] or [using] for more complex situations. For
 * these instances, the [Defer.deferClose] extension function provides a convenient way to register closing an
 * [AutoCloseable] resource as a deferred action.
 *
 * Deferred actions are executed in the reverse order they are registered, in a first-in-last-out manner. To put it
 * another way, the first deferred action registered will be the last to execute.
 *
 * If an exception is thrown during execution of [block], and a deferred action throws an exception as well, the latter
 * exception is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * @param block a function to execute, with any deferred actions registered executed upon completion.
 * @return the result of [block] function, after all deferred actions have completed.
 * @see deferrable
 * @see using
 * @see use
 */
inline fun <R> deferrableCatching(block: Defer.() -> R): Result<R> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return try {
        Result.success(deferrable(block))
    } catch (t: Throwable) {
        Result.failure(t)
    }
}

/**
 * A manager of deferred action. This class should typically not be used directly, use [deferrable] instead.
 * @see deferrable
 */
class Defer {
    private val deferredActions = mutableListOf<DeferredAction>()

    /**
     * Mark this [AutoCloseable] resource to be closed automatically upon the completion of the outer [deferrable] block.
     *
     * This resource is guaranteed to be closed correctly, whether an exception is thrown or not.
     */
    fun <T : AutoCloseable> T.deferClose(): T = apply {
        defer {
            close()
        }
    }

    /**
     * Mark all [AutoCloseable] resources present in this iterable to be closed automatically upon the completion of
     * the outer [deferrable] block.
     *
     * Every resource is guaranteed to be closed correction, whether an exception is thrown or not. `null` values are
     * ignored.
     */
    fun Iterable<AutoCloseable?>.deferCloseAll() {
        forEach { res ->
            res?.let {
                defer { it.close() }
            }
        }
    }

    /**
     * Mark all [AutoCloseable] resources present in this array to be closed automatically upon the completion of
     * the outer [deferrable] block.
     *
     * Every resource is guaranteed to be closed correction, whether an exception is thrown or not. `null` values are
     * ignored.
     */
    fun Array<out AutoCloseable?>.deferCloseAll() {
        forEach { res ->
            res?.let {
                defer { it.close() }
            }
        }
    }

    /**
     * Schedule the given [DeferredAction] to be executed upon the completion of the outer [deferrable] block.
     *
     * @param action a function to defer
     */
    fun defer(action: DeferredAction) {
        deferredActions += action
    }

    /**
     * Run all registered deferred actions, adding any exceptions that are thrown as suppressed exceptions to the given
     * [originalThrown] exception, and returning the final exception, if there is one.
     *
     * This function is not intended to be used directly, it is called automatically when using [deferrable].
     *
     * @param originalThrown The exception that was previously thrown during execution of the [deferrable] block, or
     *                       `null` if no exception was thrown.
     * @return The final exception, after having executed all deferred actions. If [originalThrown] was provided, this
     *         will be the same exception object, but with any additional exceptions added as suppressed exceptions.
     */
    fun runDeferred(originalThrown: Throwable? = null): Throwable? {
        var thrown: Throwable? = originalThrown
        for (action in deferredActions.asReversed()) {
            try {
                action()
            } catch (t: Throwable) {
                thrown = thrown?.apply { addSuppressed(t) } ?: t
            }
        }
        deferredActions.clear()
        return thrown
    }
}

/**
 * A function which is guaranteed to be executed upon the completion of a [deferrable] block, whether an exception is
 * thrown or not.
 */
typealias DeferredAction = () -> Unit
