package org.advanced.partFour;

import java.util.Arrays;

public class DPOne {
    static int globalAns=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int n=12;
        int[] dp=new int[n+1];
        for(int i=0; i<n+1;i++) dp[i]=-1;
        //System.out.println(fib(5,dp));
        //System.out.println(Arrays.toString(dp));
        System.out.println(minSqaures(n,dp));
    }
    private static int minSqaures(int N,int[] dp){
        System.out.println("Called for: "+N);
        if(N==0) return 0;
        if(dp[N] !=-1) return dp[N];
        int t_ans=Integer.MAX_VALUE;
        for(int i=1; i*i<=N;i++){
            t_ans=Math.min(t_ans,minSqaures(N-(i*i),dp));
        }
        dp[N]=t_ans+1;
        return dp[N];
    }
    private static int fib(int n,int[] dp){

        if(n<=1) return n;
        if(dp[n] !=-1) return dp[n];
        System.out.println("Called for: "+n);
        dp[n]=fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
    private static int nearestSquare(int N){
        System.out.println("Called for: "+N);
        int ans=1;
        for(int i=1; i*i<=N;i++){
            ans=i*i;
        }
        return ans;
    }
}
