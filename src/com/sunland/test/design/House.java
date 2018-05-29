package com.sunland.test.design;

import java.util.Observable;

/**
 * Author: wangzn
 * DateTime: 2018/5/18 20:53
 */
class House extends Observable {
    private double price;

    public House(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (this.price != price) {
            this.price = price;
            setChanged();  //标注价格已经被更改
            notifyObservers(price);  //通知观察者数据已被更改
        }
    }

    @Override
    public String toString() {
        return "当前房价为：" + price;
    }
}
