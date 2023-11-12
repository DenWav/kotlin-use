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

@file:Suppress("DuplicatedCode")

package dev.denwav.use

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, R> using(
    t0: T0,
    block: (T0) -> R,
): R
        where T0 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return t0.use(block)
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, R> using(
    t0: T0,
    t1: T1,
    block: (T0, T1) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        block(t0, t1)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    block: (T0, T1, T2) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        block(t0, t1, t2)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    block: (T0, T1, T2, T3) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        block(t0, t1, t2, t3)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    block: (T0, T1, T2, T3, T4) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        block(t0, t1, t2, t3, t4)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    block: (T0, T1, T2, T3, T4, T5) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        block(t0, t1, t2, t3, t4, t5)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    block: (T0, T1, T2, T3, T4, T5, T6) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    block: (T0, T1, T2, T3, T4, T5, T6, T7) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param t8 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    t8: T8,
    block: (T0, T1, T2, T3, T4, T5, T6, T7, T8) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable,
              T8 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        t8.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7, t8)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param t8 an [AutoCloseable] resource to use and close upon completion.
 * @param t9 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> using(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    t8: T8,
    t9: T9,
    block: (T0, T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R,
): R
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable,
              T8 : AutoCloseable,
              T9 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrable {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        t8.deferClose()
        t9.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9)
    }
}

//
// CATCHING VARIANTS
//

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, R> useCatching(
    t0: T0,
    block: (T0) -> R,
): Result<R>
        where T0 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return runCatching {
        t0.use(block)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, R> useCatching(
    t0: T0,
    t1: T1,
    block: (T0, T1) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        block(t0, t1)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    block: (T0, T1, T2) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        block(t0, t1, t2)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    block: (T0, T1, T2, T3) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        block(t0, t1, t2, t3)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    block: (T0, T1, T2, T3, T4) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        block(t0, t1, t2, t3, t4)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    block: (T0, T1, T2, T3, T4, T5) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        block(t0, t1, t2, t3, t4, t5)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    block: (T0, T1, T2, T3, T4, T5, T6) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    block: (T0, T1, T2, T3, T4, T5, T6, T7) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param t8 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    t8: T8,
    block: (T0, T1, T2, T3, T4, T5, T6, T7, T8) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable,
              T8 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        t8.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7, t8)
    }
}

/**
 * Executes the given [block] function on all given resources and then closes them all down correctly whether an
 * exception is thrown or not.
 *
 * In case if the resource is being closed due to an exception occurred in [block], and the closing also fails with an
 * exception, the latter is added to the [suppressed][Throwable.addSuppressed] exceptions of the former.
 *
 * Resources are closed from right to left as they appear in the parameter list.
 *
 * @param t0 an [AutoCloseable] resource to use and close upon completion.
 * @param t1 an [AutoCloseable] resource to use and close upon completion.
 * @param t2 an [AutoCloseable] resource to use and close upon completion.
 * @param t3 an [AutoCloseable] resource to use and close upon completion.
 * @param t4 an [AutoCloseable] resource to use and close upon completion.
 * @param t5 an [AutoCloseable] resource to use and close upon completion.
 * @param t6 an [AutoCloseable] resource to use and close upon completion.
 * @param t7 an [AutoCloseable] resource to use and close upon completion.
 * @param t8 an [AutoCloseable] resource to use and close upon completion.
 * @param t9 an [AutoCloseable] resource to use and close upon completion.
 * @param block a function to process all [AutoCloseable] resources.
 * @return the result of [block] function invoked on these resources.
 * @see AutoCloseable.use
 * @see deferrable
 */
inline fun <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> useCatching(
    t0: T0,
    t1: T1,
    t2: T2,
    t3: T3,
    t4: T4,
    t5: T5,
    t6: T6,
    t7: T7,
    t8: T8,
    t9: T9,
    block: (T0, T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R,
): Result<R>
        where T0 : AutoCloseable,
              T1 : AutoCloseable,
              T2 : AutoCloseable,
              T3 : AutoCloseable,
              T4 : AutoCloseable,
              T5 : AutoCloseable,
              T6 : AutoCloseable,
              T7 : AutoCloseable,
              T8 : AutoCloseable,
              T9 : AutoCloseable {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return deferrableCatching {
        t0.deferClose()
        t1.deferClose()
        t2.deferClose()
        t3.deferClose()
        t4.deferClose()
        t5.deferClose()
        t6.deferClose()
        t7.deferClose()
        t8.deferClose()
        t9.deferClose()
        block(t0, t1, t2, t3, t4, t5, t6, t7, t8, t9)
    }
}
