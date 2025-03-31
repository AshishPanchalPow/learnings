package org.example;
import java.util.*;

import java.util.HashMap;

public class LeetCodeProblems {
    public static void main(String[] args) {
        int[] nums= {1,1,1,0};
        threeSumClosest(nums,-100);
    }
    private static int threeSumClosest(int[] nums, int target){
        int N=nums.length;
        int ans=Integer.MAX_VALUE;
        int maxPossibleDiff=Integer.MAX_VALUE;
        for(int i=0; i<N-2; i++){
            for(int j=i+1;j<N-1;j++){
                for(int k=j+1;k<N;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    int absDiff=Math.abs(sum-target);
                    if(absDiff<maxPossibleDiff){
                        ans=sum;

                    }
                    System.out.println(nums[i]+ " "+nums[j]+" "+nums[k]);
                    System.out.println(absDiff);
                }
            }
        }
        System.out.println("main ans: "+ans);
        return ans;
    }
    private static int[] twoSum(int[] nums, int target){
        int[] ans=new int[2];
        Map<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                ArrayList<Integer> arrayList=hashMap.get(nums[i]);
                arrayList.add(i);
                hashMap.put(nums[i],arrayList);
            }
            else {
                ArrayList<Integer> arrayList=new ArrayList<>();
                arrayList.add(i);
                hashMap.put(nums[i],arrayList);
            }
        }
        System.out.println(hashMap);
        for(int i=0; i<nums.length;i++){
            int numToLookFor=target-nums[i];
            if(hashMap.containsKey(numToLookFor)){
                ArrayList<Integer> arrayList=hashMap.get(numToLookFor);
                if(numToLookFor==nums[i] ){
                    if(arrayList.size()>1){
                        ans[0]=arrayList.get(0);
                        ans[1]=arrayList.get(1);
                    }
                }
                else{
                    ans[0]=i;
                    ans[1]=arrayList.get(0);
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
