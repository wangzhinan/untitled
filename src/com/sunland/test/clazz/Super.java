package com.sunland.test.clazz;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Super {
    public abstract void testOverride() throws IOException;

    public void testThrowable() throws FileNotFoundException{

    }
}