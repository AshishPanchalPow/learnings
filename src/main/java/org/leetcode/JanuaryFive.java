package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class JanuaryFive {
    public static void main(String[] args) {
        int[] nums={2,3,0,1,4};
        HashMap<Integer,Integer> memo=new HashMap<>();
        System.out.println(minSteps(nums,0,memo));
    }
    private static int minSteps(int[] nums, int index, HashMap<Integer,Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index>=nums.length-1){
            memo.put(index,0);
            return 0;
        }
        if(nums[index]==0){
            memo.put(index,Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int currVal=nums[index];
        int minSteps=Integer.MAX_VALUE;
        for(int i=currVal;i>=1;i--){
            int localSteps=minSteps(nums, index+i,memo);
            if(localSteps!=Integer.MAX_VALUE){
                localSteps +=1;
                minSteps=Math.min(minSteps,localSteps);
            }
        }
        memo.put(index,minSteps);
        return minSteps;
    }
    public static int robOneToN(int[] nums) {
        int N=nums.length;
        int[] dp=new int[N];
        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<N;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[N-1];
    }
    public static int robZeroToNMinusOne(int[] nums) {
        int N=nums.length;
        int[] dp=new int[N];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<N;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[N-1];
    }
}
