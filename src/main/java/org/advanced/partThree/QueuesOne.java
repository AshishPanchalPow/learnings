package org.advanced.partThree;

import java.util.*;

public class QueuesOne {
    int front=-1;
    int rear=-1;
    int N=5;
    int[] q=new int[N];
    int size=0;

    void enqueue(int x){
        if(size==N) {
            System.out.println("Queue is Full");
            return;
        }
        rear=(rear+1)%N;
        q[rear]=x;
        size++;
    }
    int deque(){
        if (size==0) return -1;
        front=(front+1)%N;
        size--;
        return q[front];
    }
    int front(){
        front=(front+1)%N;
        return q[front];
    }

    public static void main(String[] args) {
        System.out.println("Hello Queues");
        //System.out.println(kthMagic(10));
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
//        System.out.println(deque.pollFirst());
//        System.out.println("Ath Magic number: "+ AthPerfectNumber(9));
        Integer[] arr={1, 3, -1, -3, 5, 3, 6, 7};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(arr));
        slidingMaximum(arrayList,3);
    }
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {


        return null;
    }
    public static String AthPerfectNumber(int A){
        if(A==1) return "11";
        if(A==2) return "22";
        Queue<String > queue=new LinkedList<>();
        queue.add("11");
        queue.add("12");
        queue.add("21");
        queue.add("22");
        int counter=2;

       while (!queue.isEmpty()){
            String curr=queue.poll();
            String curr1=curr+"11";
            queue.add(curr1);
            if(isPalindrome(curr1)){
                counter++;
                if(counter==A) return curr1;
            }

            String curr2=curr+"12";
            queue.add(curr2);
            if(isPalindrome(curr2)){
                counter++;
                if(counter==A) return curr2;
            }
            String curr3=curr+"21";
            queue.add(curr3);
            if(isPalindrome(curr3)){
                counter++;
                if(counter==A) return curr3;
            }
            String curr4=curr+"22";
            queue.add(curr4);
            if(isPalindrome(curr4)){
                counter++;
                if(counter==A) return curr4;
            }
        }



        return "";
    }
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false; // Null strings are not considered palindromes
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public static String kthMagic(int K){
        Queue<String > queue= new LinkedList<>();
        queue.add("1");
        queue.add("2");
        for(int i=3; i<=K;i++){
            String curr=queue.poll();
            String first=curr+"1";
            queue.add(first);
            if(i==K) return first;
            i++;
            String second=curr+"2";
            queue.add(second);
            if (i==K) return second;
        }
        return "";
    }

}
