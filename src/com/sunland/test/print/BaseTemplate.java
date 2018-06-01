package com.sunland.test.print;

import java.util.Map;

public abstract class BaseTemplate<T,E> {
    private T data;
    private Map<String, Object> extras;
    private int totalPage;
    private int currentPage = 1;

    public BaseTemplate(T data, Map<String, Object> extras, int totalPage) {
        this.data = data;
        this.extras = extras;
        this.totalPage = totalPage;
    }

    public T getData() {
        return data;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setNextPage() {
        currentPage++;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public abstract int doPrint(E printer, T data, Map<String, Object> extras, int totalPage) throws Exception;

}
