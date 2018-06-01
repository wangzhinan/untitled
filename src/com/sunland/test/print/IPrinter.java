package com.sunland.test.print;

public interface IPrinter<E> {
    E getPrinter();
    boolean openDevice(Object params);
}
