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
import kotlin.test.assertFails
import kotlin.test.assertSame
import kotlin.test.assertTrue

class UsingTest {

    @Test
    fun test1() {
        val c1 = Closeable()
        using(c1) { t1 ->
            assertSame(c1, t1)
        }
        assertTrue(c1.closed)
    }

    @Test
    fun test1Throws() {
        val c1 = Closeable()
        assertFails {
            using(c1) { t1 ->
                assertSame(c1, t1)
                fail()
            }
        }
        assertTrue(c1.closed)
    }

    @Test
    fun test2() {
        val c1 = Closeable()
        val c2 = Closeable()
        using(c1, c2) { t1, t2 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
    }

    @Test
    fun test2Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        assertFails {
            using(c1, c2) { t1, t2 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
    }

    @Test
    fun test3() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        using(c1, c2, c3) { t1, t2, t3 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
    }

    @Test
    fun test3Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        assertFails {
            using(c1, c2, c3) { t1, t2, t3 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
    }

    @Test
    fun test4() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        using(c1, c2, c3, c4) { t1, t2, t3, t4 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
    }

    @Test
    fun test4Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        assertFails {
            using(c1, c2, c3, c4) { t1, t2, t3, t4 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
    }

    @Test
    fun test5() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        using(c1, c2, c3, c4, c5) { t1, t2, t3, t4, t5 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
    }

    @Test
    fun test5Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5) { t1, t2, t3, t4, t5 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
    }

    @Test
    fun test6() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        using(c1, c2, c3, c4, c5, c6) { t1, t2, t3, t4, t5, t6 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
    }

    @Test
    fun test6Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5, c6) { t1, t2, t3, t4, t5, t6 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                assertSame(c6, t6)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
    }

    @Test
    fun test7() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        using(c1, c2, c3, c4, c5, c6, c7) { t1, t2, t3, t4, t5, t6, t7 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
    }

    @Test
    fun test7Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5, c6, c7) { t1, t2, t3, t4, t5, t6, t7 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                assertSame(c6, t6)
                assertSame(c7, t7)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
    }

    @Test
    fun test8() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        using(c1, c2, c3, c4, c5, c6, c7, c8) { t1, t2, t3, t4, t5, t6, t7, t8 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
    }

    @Test
    fun test8Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5, c6, c7, c8) { t1, t2, t3, t4, t5, t6, t7, t8 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                assertSame(c6, t6)
                assertSame(c7, t7)
                assertSame(c8, t8)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
    }

    @Test
    fun test9() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        using(c1, c2, c3, c4, c5, c6, c7, c8, c9) { t1, t2, t3, t4, t5, t6, t7, t8, t9 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
    }

    @Test
    fun test9Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5, c6, c7, c8, c9) { t1, t2, t3, t4, t5, t6, t7, t8, t9 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                assertSame(c6, t6)
                assertSame(c7, t7)
                assertSame(c8, t8)
                assertSame(c9, t9)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
    }

    @Test
    fun test10() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val c10 = Closeable()
        using(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) { t1, t2, t3, t4, t5, t6, t7, t8, t9, t10 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
            assertSame(c10, t10)
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
        assertTrue(c10.closed)
    }

    @Test
    fun test10Throws() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val c10 = Closeable()
        assertFails {
            using(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) { t1, t2, t3, t4, t5, t6, t7, t8, t9, t10 ->
                assertSame(c1, t1)
                assertSame(c2, t2)
                assertSame(c3, t3)
                assertSame(c4, t4)
                assertSame(c5, t5)
                assertSame(c6, t6)
                assertSame(c7, t7)
                assertSame(c8, t8)
                assertSame(c9, t9)
                assertSame(c10, t10)
                fail()
            }
        }
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
        assertTrue(c10.closed)
    }

    //
    // CATCHING VARIANTS
    //

    @Test
    fun test1Catching() {
        val c1 = Closeable()
        val res = useCatching(c1) { t1 ->
            assertSame(c1, t1)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
    }

    @Test
    fun test1ThrowsCatching() {
        val c1 = Closeable()
        val res = useCatching(c1) { t1 ->
            assertSame(c1, t1)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
    }

    @Test
    fun test2Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val res = useCatching(c1, c2) { t1, t2 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
    }

    @Test
    fun test2ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val res = useCatching(c1, c2) { t1, t2 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
    }

    @Test
    fun test3Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val res = useCatching(c1, c2, c3) { t1, t2, t3 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
    }

    @Test
    fun test3ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val res = useCatching(c1, c2, c3) { t1, t2, t3 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
    }

    @Test
    fun test4Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val res = useCatching(c1, c2, c3, c4) { t1, t2, t3, t4 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
    }

    @Test
    fun test4ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val res = useCatching(c1, c2, c3, c4) { t1, t2, t3, t4 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
    }

    @Test
    fun test5Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5) { t1, t2, t3, t4, t5 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
    }

    @Test
    fun test5ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5) { t1, t2, t3, t4, t5 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
    }

    @Test
    fun test6Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6) { t1, t2, t3, t4, t5, t6 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
    }

    @Test
    fun test6ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6) { t1, t2, t3, t4, t5, t6 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
    }

    @Test
    fun test7Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7) { t1, t2, t3, t4, t5, t6, t7 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
    }

    @Test
    fun test7ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7) { t1, t2, t3, t4, t5, t6, t7 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
    }

    @Test
    fun test8Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8) { t1, t2, t3, t4, t5, t6, t7, t8 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
    }

    @Test
    fun test8ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8) { t1, t2, t3, t4, t5, t6, t7, t8 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
    }

    @Test
    fun test9Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8, c9) { t1, t2, t3, t4, t5, t6, t7, t8, t9 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
    }

    @Test
    fun test9ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8, c9) { t1, t2, t3, t4, t5, t6, t7, t8, t9 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
    }

    @Test
    fun test10Catching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val c10 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) { t1, t2, t3, t4, t5, t6, t7, t8, t9, t10 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
            assertSame(c10, t10)
        }
        assertTrue(res.isSuccess)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
        assertTrue(c10.closed)
    }

    @Test
    fun test10ThrowsCatching() {
        val c1 = Closeable()
        val c2 = Closeable()
        val c3 = Closeable()
        val c4 = Closeable()
        val c5 = Closeable()
        val c6 = Closeable()
        val c7 = Closeable()
        val c8 = Closeable()
        val c9 = Closeable()
        val c10 = Closeable()
        val res = useCatching(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) { t1, t2, t3, t4, t5, t6, t7, t8, t9, t10 ->
            assertSame(c1, t1)
            assertSame(c2, t2)
            assertSame(c3, t3)
            assertSame(c4, t4)
            assertSame(c5, t5)
            assertSame(c6, t6)
            assertSame(c7, t7)
            assertSame(c8, t8)
            assertSame(c9, t9)
            assertSame(c10, t10)
            fail()
        }
        assertTrue(res.isFailure)
        assertTrue(c1.closed)
        assertTrue(c2.closed)
        assertTrue(c3.closed)
        assertTrue(c4.closed)
        assertTrue(c5.closed)
        assertTrue(c6.closed)
        assertTrue(c7.closed)
        assertTrue(c8.closed)
        assertTrue(c9.closed)
        assertTrue(c10.closed)
    }
}
