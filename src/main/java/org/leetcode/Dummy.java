package org.leetcode;

import java.util.*;

public class Dummy {
    public static void main(String[] args) {
        //System.out.println(steps(10,4));
        int[] g={1,2,3};
        int[] s={1,1};
        //findContentChildren(g,s);
        int[] nums={2,0,0};
        System.out.println(canJump(nums));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0; int N=flowerbed.length;
        int res =0;
        while (i<N){
            if(flowerbed[i] !=1){
                int localZero=1;
                while (flowerbed[++i] !=1){
                    localZero++;
                }
                if(localZero%2==0) localZero--;
                res +=localZero/2;
            }
            i++;
        }
        return res>=n;
    }

    public int longestPalindrome(String s) {
        int res=0;
        Map<Character, Integer> freq=new HashMap<>();
        for(int i=0; i<s.length();i++){
            if(freq.containsKey(s.charAt(i))){
                int f=freq.get(s.charAt(i));
                f++;
                freq.put(s.charAt(i),f);
            }
            else{
                freq.put(s.charAt(i),1);
            }
        }
        boolean hasOdd=false;
        for(Character key: freq.keySet()){
            int currCount=freq.get(key);
            if(currCount%2 !=0) hasOdd=true;
            res +=currCount-currCount%2;
        }
        if(hasOdd) res +=1;
        return res;
    }
    public static boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        for(int i=0; i<nums.length;i++){

            if(nums[i]==0){
                int currIdx=i;
                int ONE=1;
                while (currIdx>0){
                    currIdx--;
                    if(nums[currIdx]>ONE){
                        break;
                    }
                    ONE++;

                }
                if(currIdx==0 && nums[currIdx]<=ONE) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int steps(int target, int maxDoubles){
        int res=0;
        while(maxDoubles>0 & target>1){
            if(target %2==0){
                target /=2;
                maxDoubles--;
                res +=1;
            }
            else {
                target -=1;
                res +=1;
                target /=2;
                maxDoubles--;
                res+=1;
            }
        }
        return res+target-1;
    }
    public static int findContentChildren(int[] g, int[] s){
        //cookies are s.
        // students are g.
        Arrays.sort(g);
        Queue<Integer> minHeap=new PriorityQueue<>();
        for(int i: s) minHeap.add(i);
//        System.out.println(Arrays.toString(g));
//        System.out.println(minHeap);
        int res=0;
        for(int i=0; i<g.length; i++){
            int curr=g[i];
            while (!minHeap.isEmpty() && (minHeap.peek()<curr)){
                minHeap.poll();
            }
            if(!minHeap.isEmpty() && minHeap.peek()>=curr){
                res++;
                minHeap.poll();
            }
        }
        return res;
    }
}
