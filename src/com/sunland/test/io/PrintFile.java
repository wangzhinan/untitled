package com.sunland.test.io;

import java.io.*;

/**
 * Author: wangzn
 * DateTime: 2018/5/2 20:32
 */
public class PrintFile extends PrintStream {
    public PrintFile(String filename) throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(filename)));
    }

    public PrintFile(File file) throws IOException {
        this(file.getPath());
    }
}
