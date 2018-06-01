package com.sunland.test.design;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Author: wangzn
 * DateTime: 2018/5/19 7:53
 */
public class ListView implements Observer {
    private Adapter adapter;

    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        adapter.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Adapter adapter = (Adapter) o;
        List<String> d = (List<String>) arg;
        for (String s : d) {
            System.out.println(s);
        }
    }
}
