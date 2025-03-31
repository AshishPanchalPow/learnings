package leetcode;

import java.util.Stack;

class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> secondaryStack;
    public MinStack() {
        mainStack=new Stack<>();
        secondaryStack=new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if(secondaryStack.isEmpty()) secondaryStack.push(val);
        else if(secondaryStack.peek()>=val) secondaryStack.push(val);
    }

    public void pop() {
        Integer popped=mainStack.pop();
        if(popped.equals(secondaryStack.peek())){
            secondaryStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return secondaryStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}
