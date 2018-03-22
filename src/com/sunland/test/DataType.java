package com.sunland.test;

enum DataType{
    A(1),B(2),C(3),TEST(4);
    private int value;
    DataType(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }
}