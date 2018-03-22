package com.sunland.test.print;

public interface PrintStatusListener {
    void onSuccess(int currentPage);
    void onError(int currentPage,int errCode,String errMessage);
}
