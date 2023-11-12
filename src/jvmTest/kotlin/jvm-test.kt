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

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import java.sql.Connection
import kotlin.test.Test

class JvmTest {

    @Test
    fun testUsing() {
        val connection = mockk<Connection>()
        every { connection.close() } just runs

        using(connection) {
        }

        verify(exactly = 1) { connection.close() }
    }

    @Test
    fun testDeferring() {
        val connection = mockk<Connection>()
        every { connection.close() } just runs

        deferrable {
            connection.deferClose()
        }

        verify(exactly = 1) { connection.close() }
    }
}
