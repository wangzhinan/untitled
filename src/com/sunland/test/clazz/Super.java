package com.sunland.test.clazz;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Super {
    public abstract void testOverride() throws IOException;

    protected void testThrowable() throws FileNotFoundException{
        System.out.println("testThrowale super");
        callBack();
    }

    public void callBack(){
        System.out.println("callBack super");
    }


}
