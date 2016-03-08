package com.github.droibit.plugin.truth.postfix.example;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.util.Arrays.asList;
import static org.junit.Assert.fail;

/**
 * @author kumagai
 */
public class TruthPostfixTest {

    private int field = 1;

    @Test
    public void assertThatWithInt() {
        int actual = 100;
        assertThat(actual).isEqualTo(100);
    }

    @Test
    public void assertThatWithIntField() {
        assertThat(field).isEqualTo(1);
    }

    @Test
    public void assertThatWithIntLiteral() {
        assertThat(100).isEqualTo(100);
    }

    @Test
    public void assertThatWithFloat() {
        float actual = 100.0f;
        assertThat(actual).isWithin(100.0f);
    }

    @Test
    public void assertThatWithDouble() {
        double actual = 100.0;
        assertThat(actual).isWithin(100);
    }

    @Test
    public void assertThatWithStringMethod() {
        String actual = "hoge";
        assertThat(actual.isEmpty()).isFalse();
    }

    @Test
    public void truthAssertWithMessage() {
        try {
            assertWithMessage("custom msg").that(asList(1, 2, 3)).contains(5);
            fail("Should have thrown.");
        } catch (AssertionError e) {
            assertThat(e).hasMessage("custom msg: <[1, 2, 3]> should have contained <5>");
        }
    }
}
