package com.sunland.test.print;

public class MyPrinter extends BasePrinter {
    public MyPrinter(BaseTemplate baseTemplate, PrintStatusListener listener) {
        super(baseTemplate, listener);
    }

    @Override
    public String getErrMessage() {
        return "error";
    }

    @Override
    public Object getPrinter() {
        return new PrinterManager();
    }

    @Override
    public boolean openDevice(Object params) {
        return true;
    }
}
