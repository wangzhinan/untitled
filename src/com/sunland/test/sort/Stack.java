package sort;

public class Stack {
    private int[] stack;
    private int top = -1;
    private int maxSize;

    public Stack(int max){
        maxSize = max;
        stack = new int[max];
    }

    public void push(int value){
        stack[++top] = value;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmity(){
        return top < 0;
    }

    public boolean isFull(){
        return top > maxSize-1;
    }
}
