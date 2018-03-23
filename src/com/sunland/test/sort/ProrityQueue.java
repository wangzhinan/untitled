package com.sunland.test.sort;

import java.util.Arrays;

public class ProrityQueue {
    private int maxSize;
    private int[] queue;
    private int size;
    private int item = 0;

    public ProrityQueue(int size){
        this.maxSize = size;
        queue = new int[size];
    }

    public void insert(int value){
        if (isFull()) return;
        if (item == 0){
            queue[item] = value;
        }else {
            int i;//85
            for (i = item -1; i >= 0; i--) {
                System.out.println(i);
                if (queue[i] > value ){
                    queue[i+1] = queue[i];//[0,85]
                }else {
                    System.out.println("break");
                    break;
                }
            }
            System.out.println(i);
            queue[i+1] = value;//
        }
        item++;
    }

    public int remove(){
        if (!isEmity()){
            return queue[--item];
        }
        return -1;
    }
    public int size(){
        return size;
    }

    public boolean isFull(){
        return item >= maxSize;
    }

    public boolean isEmity(){
        return size <= 0;
    }

     public void disPlay(){
         System.out.println(Arrays.toString(queue));
     }
}
