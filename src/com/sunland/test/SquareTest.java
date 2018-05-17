package com.sunland.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SquareTest {
    private int a;
    private int b;
    private int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2, 5, 7},
                {0, 3, 3},
                {-3, 0, -3},
        });
    }

    //构造函数，对变量进行初始化
    public SquareTest(int a, int b, int result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Test
    public void square() {
        assertEquals(result, add(a,b));
    }

    public int add(int a, int b) {
        return a + b;
    }
}