package com.github.droibit.plugin.truth.postfix.example

import com.google.common.truth.Truth
import org.junit.Test

/**
 * @author kumagai
 */
class ImportTest {

    @Test
    fun test() {
        val actual = 1
        Truth.assertThat(actual).isEqualTo(10)
    }
}

