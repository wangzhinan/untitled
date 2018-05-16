package com.sunland.test.typeinfo;

/**
 * Author: wangzn
 * DateTime: 2018/4/25 20:56
 */
public class PassHandles {
    static void f(PassHandles h) {
        System.out.println("h inside f(): " + h);
    }

    public static void main(String[] args) {
        PassHandles p = new PassHandles();
        System.out.println("p inside main(): " + p);
        f(p);
    }
}
