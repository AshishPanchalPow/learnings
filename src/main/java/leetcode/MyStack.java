package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
    Queue<Integer> mainQueue;
    Queue<Integer> secondQueue;
    public MyStack() {
       mainQueue=new LinkedList<>();
       secondQueue=new LinkedList<>();
    }

    public void push(int x) {
        mainQueue.add(x);
    }

    public int pop() {
        if(mainQueue.size()==0) return -1;
        while (mainQueue.size() !=1){
            secondQueue.add(mainQueue.poll());
        }
        int output= mainQueue.poll();
        mainQueue.addAll(secondQueue);
        secondQueue.clear();
        return output;
    }

    public int top() {
        if(mainQueue.size()==0) return -1;
        while (mainQueue.size() !=1){
            secondQueue.add(mainQueue.poll());
        }
        int output= mainQueue.poll();
        secondQueue.add(output);
        mainQueue.addAll(secondQueue);
        secondQueue.clear();
        return output;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
