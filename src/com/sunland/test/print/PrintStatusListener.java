package com.sunland.test.print;

public interface PrintStatusListener {
    void onSuccess(int currentPage, int totalPage, BasePrinter basePrinter);

    void onError(int currentPage, int errCode, String errMessage,BasePrinter basePrinter);
}
