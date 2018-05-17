package com.sunland.test.collection;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain {
    private static int  n;
    public static void main(String[] args) {
    }

    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("data" + i);
        }
        List<String> subList = list.subList(0, 5);
        for (int i = 0; i < subList.size(); i++) {
            System.out.println(subList.get(i));
        }
        subList.clear();
        for (int i = 10; i < 15; i++) {
            list.add("data" + i);
        }
        for (int i = 0; i < subList.size(); i++) {
            System.out.println(subList.get(i));
        }

    }

    @Test
    public void testRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s))
                list.remove(s);
        }

    }

    @Test
    public void testArrayToList() {
        String[] strings = {"a", "b", "c"};
        List<String> list = Arrays.asList(strings);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        strings[2] = "d";
        System.out.println("------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        int c = 5 + 6;

    }

    @Test
    public void test() {
        List<? super Number> list = new ArrayList<Object>();
        list.add(1);
        Number number = 23;
        Integer integer = 3;
        list.add(integer);
        Double d = 5.8;
        list.add(d);
        list.add(number);

    }


    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        Set<Integer> key = map.keySet();
        for (Integer aKey : key) {
            System.out.println(aKey);
        }
    }

    private static final ThreadLocal<DateFormat> df =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

}
