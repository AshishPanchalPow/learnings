package org.advanced.partThree;

import java.util.*;

public class HeapsTwo {
    public static void main(String[] args) {
        Integer[] arr={10,2,13,4,-10};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(arr));
        //solve(arrayList);
        //solve(3,arrayList);
        //solve(arrayList,2);
        top3Product(arrayList);
    }
    public static ArrayList<Integer> top3Product(ArrayList<Integer>A){
        int K=3;
        int N=A.size();
        Integer[] ans=new Integer[N];
        Arrays.fill(ans,-1);
        Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0; i<K-1;i++){
            minHeap.add(A.get(i));
        }
        for(int i=K-1; i<N;i++){
            // Add incoming element
            Integer curr=A.get(i);
            minHeap.add(curr);
            if(minHeap.size()>3){
                minHeap.poll();
            }
            Integer one=minHeap.poll();
            Integer two=minHeap.poll();
            Integer three=minHeap.poll();
            ans[i]=one*two*three;
            minHeap.add(one);
            minHeap.add(two);
            minHeap.add(three);
        }



        return new ArrayList<>(Arrays.asList(ans));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B){
        int N=A.size();
        Queue<Integer> minHeap=new PriorityQueue<>();
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0; i<=B;i++){
            minHeap.add(A.get(i));
        }
        for(int i=B+1; i<N; i++){
            ans.add(minHeap.poll());
            minHeap.add(A.get(i));
        }
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        return ans;
    }
    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        int N=B.size();
        Integer[] ans=new Integer[N];
        Arrays.fill(ans, -1);
        if(A>N){
            return new ArrayList<>(Arrays.asList(ans));
        }
        Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0; i<A-1; i++){
            minHeap.add(B.get(i));
        }

        for(int i=A-1; i<N; i++){
            Integer curr=B.get(i);
            minHeap.add(curr);
            if(minHeap.size()>A){
                minHeap.poll();
            }
            ans[i]=minHeap.peek();
        }

        return new ArrayList<>(Arrays.asList(ans));


    }
    public static ArrayList<Integer> solve(ArrayList<Integer>A){
        Queue<Integer> leftHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> rightHeap=new PriorityQueue<>();
        ArrayList<Integer> ans=new ArrayList<>();
        leftHeap.add(A.get(0));
        int leftCount=1;
        int rightCount=0;
        ans.add(leftHeap.peek());
        for(int i=1; i<A.size();i++){
            int curr=A.get(i);
            if(curr<leftHeap.peek()){
                leftHeap.add(curr);
                leftCount++;
            }
            else{
                rightHeap.add(curr);
                rightCount++;
            }
            if(leftCount-rightCount>1){
                rightHeap.add(leftHeap.poll());
                rightCount++;
                leftCount--;
            }
            else if(rightCount-leftCount>1){
                leftHeap.add(rightHeap.poll());
                leftCount++;
                rightCount--;
            }
            if(rightCount>leftCount) ans.add(rightHeap.peek());
            else ans.add(leftHeap.peek());
        }

        return ans;
    }
    public static int medianOfStream(int[] arr){
        Queue<Integer> leftHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> rightHeap=new PriorityQueue<>();
        leftHeap.add(arr[0]);
        int leftCount=1;
        int rightCount=0;
        System.out.println("Median: "+ (leftHeap.peek()));
        for(int i=1; i<arr.length;i++){
            int curr=arr[i];
            if(curr<leftHeap.peek()){
                leftHeap.add(curr);
                leftCount++;
            }
            else{
                rightHeap.add(curr);
                rightCount++;
            }
            if(leftCount-rightCount>1){
                rightHeap.add(leftHeap.poll());
                rightCount++;
                leftCount--;
            }
            else if(rightCount-leftCount>1){
                leftHeap.add(rightHeap.poll());
                leftCount++;
                rightCount--;
            }
            if(rightCount==leftCount){
                System.out.println("Median: "+ (leftHeap.peek()));
            }
            else if(leftCount>rightCount){
                System.out.println("Median: "+ (leftHeap.peek()));
            }
            else{
                System.out.println("Median: "+ rightHeap.peek());
            }
        }

        return 0;
    }
}
