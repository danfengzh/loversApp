package org.exercise;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/14.
 */
public class MinStack1 {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> minValue = new Stack<Integer>();

    public void push(int x) {
        data.push(x);
        if (minValue.isEmpty() || x <= minValue.peek())
            minValue.push(x);
    }

    public void pop() {
        int value = data.pop();
        if (value == minValue.peek())
            minValue.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minValue.peek();
    }

}