package com.sunland.test.constructor;

/**
 * Author: wangzn
 * DateTime: 2018/4/21 14:38
 */
public class Sandwich extends PortableLunch {
//    Bread b = new Bread();
//    Cheese cheese = new Cheese();
//    Letture letture = new Letture();
    Sandwich(){
        super("test");
        System.out.println("Sandwich.Sandwich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
