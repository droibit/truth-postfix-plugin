package com.github.droibit.plugin.truth.postfix.example;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by kumagai on 2016/03/04.
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
}
