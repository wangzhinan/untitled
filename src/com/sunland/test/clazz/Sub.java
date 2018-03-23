package com.sunland.test.clazz;

import org.junit.Test;

public class Sub extends Super{
    public static void main(String[] args) {

    }

    @Override
    public void testOverride() {
        super.testOverride();
        System.out.println("from Sub");
    }

    @Test
    public void test(){
        testOverride();
    }

}
