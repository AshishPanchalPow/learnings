package org.advanced.partThree;

import java.util.*;

public class HeapsOne {
    public static void main(String[] args) {
        Integer[] arr={5,7,8};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(arr));
        //System.out.println(ropes(arrayList));
        //System.out.println(chocolates(arrayList,2));
        //System.out.println(sumArray(arrayList,10));
        minPossibleLargest(arrayList,9);
    }
    public static int minPossibleLargest(ArrayList<Integer> A, int B){
        ArrayList<Integer> state=new ArrayList<>();
        for(Integer e: A) state.add(e);
        Comparator<Pair<Integer, Integer>> keyComparator = Comparator.comparing(Pair::getKey);
        Queue<Pair<Integer,Integer>> queue=new PriorityQueue<>(keyComparator);
        for(int i=0; i<A.size();i++){
            Pair<Integer, Integer> pair=new Pair<>(A.get(i)*2,i);
            queue.add(pair);
        }
        //System.out.println(queue);
        int operations=0;
        while (operations<B){
            operations++;
            Pair<Integer,Integer> top=queue.poll();
            Integer val=top.getKey();
            Integer index=top.getValue();
            state.set(index,val);
            Pair<Integer,Integer> pair=new Pair<>(val+A.get(index),index);
            queue.add(pair);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<state.size();i++){
            if(state.get(i)>ans) ans=state.get(i);
        }
        return ans;
    }
    public static int sumArray(ArrayList<Integer>A, int B){
        int sum=0;
        Queue<Integer> queue=new PriorityQueue<>();
        for(Integer num: A){
            queue.add(num);
        }
        while (B>0){
            int top=queue.poll();
            top=0-top;
            queue.add(top);
            B--;
        }
        //System.out.println(queue);
        while (!queue.isEmpty()) sum+=queue.poll();
        return sum;
    }
    public static int chocolates(ArrayList<Integer> A, int B){
        int chocs=0;
        Queue<Integer> queue=new PriorityQueue<>();
        for(Integer box: A){
            queue.add(box);
        }
        while (queue.size() !=1){
            int box1=queue.poll();
            if(box1>B) break;
            int box2=queue.poll();
            int eat=box1/2;
            chocs +=eat;
            box2 +=box1-eat;
            queue.add(box2);
        }
        if(queue.peek()<=B) chocs +=(queue.poll())/2;
        return chocs;
    }
    public static int ropes(ArrayList<Integer> A){
        Queue<Integer> queue=new PriorityQueue<>();
        for(Integer rope: A){
            queue.add(rope);
        }
        int cost=0;
        while (!queue.isEmpty()){
            int c1=queue.poll();
            int c2=!queue.isEmpty()?queue.poll():0;
            cost +=c1+c2;
            if(!queue.isEmpty()){
                queue.add(c1+c2);
            }
            else  break;
        }


        return cost;
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