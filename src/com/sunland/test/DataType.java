package com.sunland.test;

enum DataType {
    A(1) {
        @Override
        void test() {

        }
    },
    B(2) {
        @Override
        void test() {

        }
    },
    C(3) {
        @Override
        void test() {

        }
    },
    TEST(4) {
        @Override
        void test() {

        }
    };
    private int value;

    DataType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    abstract void test();

    public int getValue(){
        return value;
    }
}