package com.sunland.test.sort;

public class InToPost {
    private StackX stackX;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        stackX = new StackX(stackSize);
    }


    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stackX.displayStack("For " + c + " ");
            switch (c) {
                case '+':
                case '-':
                    gotOper(c, 1);
                    break;
                case '*':
                case '/':
                    gotOper(c, 2);
                    break;
                case '(':
                    stackX.push(c);
                    break;
                case ')':
                    gotParent(c);
                    break;
                default:
                    output = output + c;
                    break;
            }

        }
        while ((!stackX.isEmity())) {
            stackX.displayStack("While ");
            output = output + stackX.pop();
        }
        stackX.displayStack("End ");
        return output;
    }

    private void gotParent(char ch) {
        while (!stackX.isEmity()) {
            char chx = stackX.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }

    }

    private void gotOper(char c, int prec1) {
        while (!stackX.isEmity()) {
            char top = stackX.pop();
            if (top == '(') {
                stackX.push(top);
                break;
            } else {
                int prec2;
                if (top == '+' || top == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    stackX.push(top);
                    break;
                } else {
                    output += top;
                }
            }
        }
        stackX.push(c);
    }
}
