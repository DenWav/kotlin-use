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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

class DeferTest {

    @Test
    fun testDefer() {
        val c1 = Closeable()
        deferrable {
            c1.deferClose()
        }
        assertTrue(c1.closed)
    }

    @Test
    fun testDeferThrows() {
        val c1 = Closeable()
        assertFails {
            deferrable {
                c1.deferClose()

                throw Exception()
            }
        }
        assertTrue(c1.closed)
    }

    @Test
    fun testDeferCatching() {
        val c1 = Closeable()
        val res = deferrableCatching {
            c1.deferClose()
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
    }

    @Test
    fun testDeferThrowsCatching() {
        val c1 = Closeable()
        val res = deferrableCatching {
            c1.deferClose()
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
    }

    @Test
    fun testDeferOrder() {
        var counter = 0
        deferrable {
            assertEquals(0, counter)
            counter++

            defer {
                assertEquals(6, counter)
                counter++
            }

            assertEquals(1, counter)
            counter++

            defer {
                assertEquals(5, counter)
                counter++
            }

            assertEquals(2, counter)
            counter++

            defer {
                assertEquals(4, counter)
                counter++
            }

            assertEquals(3, counter)
            counter++
        }
        assertEquals(7, counter)
    }

    @Test
    fun testDeferIncomplete() {
        var counter = 0
        assertFails {
            deferrable {
                defer {
                    assertEquals(1, counter)
                    counter++
                }

                defer {
                    assertEquals(0, counter)
                    counter++
                }

                @Suppress("ConstantConditionIf")
                if (true) {
                    throw Exception()
                }

                defer {
                    error("Should not execute")
                }
            }
        }
        assertEquals(2, counter)
    }

    @Test
    fun testDeferCloseAll() {
        val closeables = listOf(Closeable(), Closeable(), Closeable())
        deferrable {
            closeables.deferCloseAll()
        }
        assertTrue(closeables.all { it.closed })
    }

    @Test
    fun testDeferCloseAllArray() {
        val closeables = arrayOf(Closeable(), Closeable(), Closeable())
        deferrable {
            closeables.deferCloseAll()
        }
        assertTrue(closeables.all { it.closed })
    }
}
