package com.sunland.test.sort;

import org.junit.Test;

import java.util.Arrays;

public class ArraySort {

    @Test
    public void testBubbleSort() {
        int[] array = createArray(12);
        System.out.println("排序前：" + Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }


    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public void insertSort(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            int temp = array[i];
//            int j = i;
//            while (j > 0 && array[j - 1] > temp) {
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[j] = temp;
//        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1];
                }else {
                    break;
                }
            }
            array[j] = temp;
        }
    }

    public int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

}
