package com.github.droibit.plugin.truth.postfix.example.delegation;

import org.junit.Test;

import static com.github.droibit.plugin.truth.postfix.example.delegation.FooSubject.foo;
import static com.google.common.truth.Truth.assertAbout;

/**
 * @author kumagai
 */
public class DelegationTest {

    @Test
    public void assertAboutWithFoo() {
        assertAbout(foo()).that(new Foo(5)).matches(new Foo(5));
    }
}
