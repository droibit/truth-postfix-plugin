package com.github.droibit.plugin.truth.postfix.example

import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * @author kumagai
 */
class TruthPostfixTest {

    private val field = 100

    @Test
    fun assertThatWithInt() {
        val actual = 100
        assertThat(actual).isEqualTo(100)
    }

    @Test
    fun assertThatWithIntField() {
        assertThat(field).isEqualTo(100)
    }

    @Test
    fun assertThatWithIntLiteral() {
        assertThat(100).isEqualTo(100)
    }

    @Test
    fun assertThatWithFloat() {
        val actual = 100f
        assertThat(actual).isWithin(100f)
    }

    @Test
    fun assertThatWithDouble() {
        val actual = 100.0
        assertThat(actual).isWithin(100.0)
    }

    @Test
    fun assertThatWithStringMethod() {
        val actual = "hoge"
        assertThat(actual.isNotEmpty()).isTrue()
    }

    @Test
    fun assertThatWithDefinedClass() {
        class Foo(val value: Int)
        val foo = Foo(value = 100)
        assertThat(foo).isNotNull()
    }
}