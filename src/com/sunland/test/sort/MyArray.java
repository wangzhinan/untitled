package com.sunland.test.sort;


public class MyArray {
    private int[] array = null;
    private int size = 0;

    public MyArray(int max){
       array = new int[max];
    }

    public int size(){
        return size;
    }

    public int get(int index){
        return array[index];
    }


    public void insert(int value){
        int i;
        for ( i = 0; i < size; i++) {
            if (array[i] > value)
                break;
        }
        for (int j = size; j > i; j--) {
            array[j] = array[j-1];
        }
        array[i] = value;
        size++;
    }

    public int find(int searchkey){
        if (array == null || array.length == 0)
            return -1;
        int start = 0;
        int end = array.length - 1;
        if (searchkey < array[0] || searchkey > array[array.length - 1])
            return -1;
        while (true) {
            int curIndex = (start + end) / 2;
            if (array[curIndex] == searchkey)
                return curIndex;
            if (array[curIndex] < searchkey)
                start = curIndex+1;
            if (array[curIndex] > searchkey)
                end = curIndex-1;
        }
    }
}
