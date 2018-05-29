package com.sunland.test.design;

import java.util.Observable;
import java.util.Observer;

/**
 * Author: wangzn
 * DateTime: 2018/5/18 20:53
 */
class HousePriceObserver implements Observer{
    private String name;
    public  HousePriceObserver(String name) {
        this.name=name;
    }
    @Override
    public void update(Observable o, Object arg) {
        //这里最好判断一下通知是否来自于房价，有可能来自其它地方
        if(o instanceof House){
            System.out.println("购物者"+name+ "观察到房价已调整为："+arg);
        }
    }
}