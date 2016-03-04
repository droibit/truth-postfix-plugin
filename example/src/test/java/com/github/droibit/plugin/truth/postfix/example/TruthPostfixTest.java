package com.github.droibit.plugin.truth.postfix.example;

import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.util.Arrays.asList;
import static org.junit.Assert.fail;

/**
 * @author kumagai
 */
public class TruthPostfixTest {

    @Test
    public void testUsingInt() {
        int actual = 100;
        assertThat(actual).isEqualTo(100);
    }

    @Test
    public void testUsingFloat() {
        float actual = 100.0f;
        assertThat(actual).isWithin(100.0f);
    }

    @Test
    public void testUsingDouble() {
        double actual = 100.0;
        assertThat(actual).isWithin(100);
    }

    @Test
    public void testCustomMessage() {
        try {
            assertWithMessage("custom msg").that(asList(1, 2, 3)).contains(5);
            fail("Should have thrown.");
        } catch (AssertionError e) {
            assertThat(e).hasMessage("custom msg: <[1, 2, 3]> should have contained <5>");
        }
    }
}
