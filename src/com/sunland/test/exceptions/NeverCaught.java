package com.sunland.test.exceptions;

/**
 * Author: wangzn
 * DateTime: 2018/4/22 13:19
 */
public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
