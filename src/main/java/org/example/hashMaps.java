package org.example;
import java.util.*;

public class hashMaps {
    public static void main(String[] args) {
        // Using HashMap
        Integer[] array={20,500,1000,200};
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(array));
        //sumAsZero(A);
        int B=0;
        System.out.println("Ans: "+diffAsB(A,B));
    }
    private static int diffAsB(ArrayList<Integer>A, int B){
        Map<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0; i<A.size();i++){
            if(hashMap.containsKey(A.get(i))){
                int freq=hashMap.get(A.get(i));
                freq++;
                hashMap.put(A.get(i),freq);
            }
            else{
                hashMap.put(A.get(i),1);
            }
        }
        System.out.println(hashMap);
        for(int i=0; i<A.size(); i++){
            int curr=A.get(i);
            int target1=curr-B; int target2=curr+B;
            if(B==0){
                if(hashMap.containsKey(target1) && hashMap.get(target1)>1){
                    return 1;
                }
            }
            else{
                if(hashMap.containsKey(target1) || hashMap.containsKey(target2)){
                    return 1;
                }
            }

        }
        return 0;
    }


    private static int sumAsZero(ArrayList<Integer>A){
        //Build pf sum
        ArrayList<Integer> pfSum=new ArrayList<>();
        pfSum.add(0,A.get(0));
        for(int i=1; i<A.size(); i++){
            pfSum.add(i, A.get(i)+pfSum.get(i-1));
        }
        System.out.println(pfSum);
        // HashMap should store sum,firstOccurenceIndex
        Map<Integer,Integer> hashmap=new HashMap<>();
        int maxLength=0;
        for(int i=0; i<A.size();i++){
            if(pfSum.get(i)==0){
                maxLength=Math.max(maxLength,i+1);
            }
            else if(hashmap.containsKey(pfSum.get(i))){
                maxLength=Math.max(maxLength,i-hashmap.get(pfSum.get(i)));
            }
            else{
                hashmap.put(pfSum.get(i),i);
            }
        }
        System.out.println("Max Length: "+maxLength );
        return maxLength;
    }

}
