package com.sunland.test.print;

public class MyPrinter extends BasePrinter {
    public MyPrinter(BaseTemplate baseTemplate, PrintStatusListener listener) {
        super(baseTemplate, listener);
    }

    @Override
    public String getErrMessage(int code) {
        String errorMessage = "";
        switch (code) {
            case -1:
                errorMessage = "error1";
                break;
            case -2:
                errorMessage = "error2";
                break;
            default:
                break;

        }
        return errorMessage;
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
