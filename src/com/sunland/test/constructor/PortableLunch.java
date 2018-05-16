package com.sunland.test.constructor;

/**
 * Author: wangzn
 * DateTime: 2018/4/21 14:37
 */
public class PortableLunch extends Lunch {
    PortableLunch(){
        System.out.println("PortableLunch.PortableLunch");
    }
    PortableLunch(String other){
        System.out.println("other = " + other);
    }
}
