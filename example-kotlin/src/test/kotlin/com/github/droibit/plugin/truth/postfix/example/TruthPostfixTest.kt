package com.github.droibit.plugin.truth.postfix.example

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * @author kumagai
 */
class TruthPostfixTest {

    @Test
    fun truthAssertThatWithInt() {
        val actual = 100
        assertThat(actual).isEqualTo(100)
    }

    @Test
    fun truthAssertThatWithFloat() {
        val actual = 100f
        assertThat(actual).isWithin(100f)
    }

    @Test
    fun truthAssertThatWithDouble() {
        val actual = 100.0
        assertThat(actual).isWithin(100.0)
    }
}