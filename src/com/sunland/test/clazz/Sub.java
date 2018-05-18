package com.sunland.test.clazz;

import org.junit.Test;

import java.io.FileNotFoundException;

public class Sub extends Super{
    public static void main(String[] args) {

    }

    private class MySub{
        public MySub(int a){

        }
    }

    @Override
    public void testOverride() throws FileNotFoundException {
        System.out.println("from Sub");
    }

    @Test
    public void test() throws FileNotFoundException{
        testThrowable();
    }

    @Override
    public void testThrowable() throws FileNotFoundException {
        super.testThrowable();
    }

    @Override
    public void callBack() {
        
    }
}
