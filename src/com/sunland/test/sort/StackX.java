package com.sunland.test.sort;

public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new char[s];
        top = -1;
    }

    public void push(char c) {
        stackArray[++top] = c;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        if (!isEmity())
            return stackArray[top];
        return 0;
    }

    public boolean isEmity() {
        return top == -1;
    }

    public int size() {
        return maxSize;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top):");
        System.out.print(peek());
        System.out.println("");
    }
}

