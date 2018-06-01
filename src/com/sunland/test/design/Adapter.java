package com.sunland.test.design;

import java.util.List;
import java.util.Observable;

/**
 * Author: wangzn
 * DateTime: 2018/5/19 7:53
 */
public class Adapter extends Observable {
    private String name;
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void notifyDataChanged(){
        setChanged();
        notifyObservers(data);
    }

}
