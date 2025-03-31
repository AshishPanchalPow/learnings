package org.advanced.partFour;

import java.util.*;

public class GreedyOne {
    public static void main(String[] args) {
        int[] times={1,2,3,3,3};
        int[] beauty={5,1,6,3,9};
        //maxBeauty(times,beauty);
        Integer[] arrA={1,7,6,2,8,4,4,6,8,2};
        Integer[] arrB={8,11,7,7,10,8,7,5,4,9};
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(arrA));
        ArrayList<Integer> B=new ArrayList<>(Arrays.asList(arrB));
        //beauty(A,B);
        //solve(A,B);
        //candy(A);
        //System.out.println(findNearestPower5(2));
        //solve(9);
        seats("............x.x");
    }
    public static int seats(String A){
        int ans=0;
        int N=A.length();
        ArrayList<Integer> seatedIndexes=new ArrayList<>();
        for(int i=0; i<A.length();i++){
            if(A.charAt(i)=='x') seatedIndexes.add(i);
        }
        int M=seatedIndexes.size();
        if(M<2)return 0;
        int medianIndex=-1;
        if(M%2==0) medianIndex=seatedIndexes.get(M/2-1);
        else medianIndex=seatedIndexes.get(M/2);
        int startingPoint=medianIndex-M+1;
        Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i=startingPoint;i<=medianIndex;i++){
            int moves=0;
            for(int j=i;j<M+i;j++){
                moves +=Math.abs(seatedIndexes.get(j-i) -j);
            }
            minHeap.add(moves);
        }
        System.out.println(minHeap);
        return minHeap.peek();
    }
    private static int mice(ArrayList<Integer> A, ArrayList<Integer> B){
        Collections.sort(A);
        Collections.sort(B);
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<A.size();i++){
            maxHeap.add(Math.abs(A.get(i)-B.get(i)));
        }
        System.out.println(maxHeap);
        return 0;
    }
    public static int solve(int A){
        int ans=0;
        while (A>0){
            A -=findNearestPower5(A);
            ans++;
        }
        return ans;
    }
    private static int findNearestPower5(int x){
        int ans=0;
        int curr=1;
        for(int i=0; i<15;i++){
            if(curr>x) {
                ans=curr;
                break;
            }
            curr=curr*5;
        }
        return ans/5;
    }
    public static int beauty(ArrayList<Integer> A, ArrayList<Integer>B){
        int ans=0;
        int N=A.size();
        ArrayList<Pair<Integer,Integer>>arrayList=new ArrayList<>();
        for(int i=0; i<N; i++){
            Pair<Integer,Integer> pair=new Pair<>(A.get(i), B.get(i));
            arrayList.add(pair);
        }
        arrayList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (Integer)o1.getKey()-(Integer) o2.getKey();
            }
        });
        System.out.println(arrayList);
        Queue<Integer> minHeap=new PriorityQueue<>();
        int runningTime=0;
        for(int i=0; i<N;i++){
            int currBeauty=arrayList.get(i).getValue();
            int currTime=arrayList.get(i).getKey();
            if(runningTime<currTime){
                //We will Buy
                minHeap.add(currBeauty);
                runningTime++;
            }
            else{
                if(!minHeap.isEmpty() &&currBeauty>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(currBeauty);
                }
            }
        }
        System.out.println(12%100);
        while (!minHeap.isEmpty()){
            ans +=(minHeap.poll()%1000000007);
        }
        return ans;
    }
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B){
        int maxTasks=1;
        int N=A.size();
        ArrayList<Pair<Integer,Integer>>arrayList=new ArrayList<>();
        for(int i=0; i<N; i++){
            Pair<Integer,Integer> pair=new Pair<>(A.get(i), B.get(i));
            arrayList.add(pair);
        }
        arrayList.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (Integer)o1.getValue()-(Integer) o2.getValue();
            }
        });
        Integer startTime=arrayList.get(0).getKey();
        Integer endTime=arrayList.get(0).getValue();
        for(int i=1; i<N; i++){
            Integer currStartTime=arrayList.get(i).getKey();
            Integer currEndTime=arrayList.get(i).getValue();
            //if no overlap increment
            if(currStartTime>=endTime){
                maxTasks++;
                endTime=currEndTime;
            }
        }

        System.out.println(arrayList);
        System.out.println(maxTasks);
        return maxTasks;
    }
    public static int candy(ArrayList<Integer> A){
        int candies=0;
        int N=A.size();
        int[] running=new int[N];
        Arrays.fill(running,1);
        //Go left to right
        for(int i=1; i<N; i++){
            if(A.get(i)>A.get(i-1)) running[i] =running[i-1]+1;
        }
        for(int i=N-2; i>=0; i--){
            if(A.get(i)>A.get(i+1)) running[i] =running[i+1]+1;
        }
        candies= Arrays.stream(running).sum();
        return candies;
    }
    private static int maxBeauty(int[] times, int[] beauty){
        int ans=0;
        Queue<Integer> minHeap=new PriorityQueue<>();
        int runningTime=0;
        for(int i=0; i<times.length;i++){
            int currBeauty=beauty[i];
            int currTime=times[i];
            if(runningTime<currTime){
                //We will Buy
                minHeap.add(currBeauty);
                runningTime++;
            }
            else{
                if(currBeauty>minHeap.peek()){
                   minHeap.poll();
                   minHeap.add(currBeauty);
                   runningTime++;
                }
            }
        }
        System.out.println(minHeap);
        return ans;
    }
}
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}
