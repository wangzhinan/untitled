package com.sunland.test.design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangzn
 * DateTime: 2018/5/18 20:58
 */
public class TestMain {
    public static void main(String[] args) {
        House house = new House(10000);
        HousePriceObserver A = new HousePriceObserver("A");
        HousePriceObserver B = new HousePriceObserver("B");
        HousePriceObserver C = new HousePriceObserver("C");
        house.addObserver(A);
        house.addObserver(B);
        house.addObserver(C);
        System.out.println(house);
        house.setPrice(6000);
        house.setPrice(8000);

    }

    @Test
    public void testAdapter(){
        ListView listView = new ListView();
        Adapter adapter = new Adapter();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("data"+i);
        }
        adapter.setData(data);
        listView.setAdapter(adapter);
        Adapter adapter1 = new Adapter();
        List<String> data1 = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            data1.add("data"+i);
        }
        adapter1.setData(data);
        listView.setAdapter(adapter1);
        adapter1.notifyDataChanged();
        adapter.notifyDataChanged();
        System.out.println("------------");
        for (int i = 5; i < 10; i++) {
            data.add("data"+i);
        }
        adapter.notifyDataChanged();
    }
}
