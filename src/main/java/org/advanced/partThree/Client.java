package org.advanced.partThree;

public class Client {
    public static void main(String[] args) {
        QueuesOne queuesOne=new QueuesOne();
        queuesOne.enqueue(10);
        queuesOne.enqueue(20);
        queuesOne.enqueue(30);
        queuesOne.enqueue(40);
        queuesOne.enqueue(50);
        queuesOne.enqueue(60);
        System.out.println(queuesOne.deque());
        System.out.println(queuesOne.deque());
        System.out.println(queuesOne.deque());
        System.out.println(queuesOne.deque());
        System.out.println(queuesOne.deque());
        System.out.println(queuesOne.deque());
        queuesOne.enqueue(100);
        queuesOne.enqueue(200);
        queuesOne.enqueue(300);
        queuesOne.enqueue(400);
        queuesOne.enqueue(500);
        System.out.println(queuesOne.front());
    }
}
