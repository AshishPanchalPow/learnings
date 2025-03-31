package org.advanced.partFour;

import java.util.Arrays;
import java.util.Collections;

public class DPOneProblems {

    public static void main(String[] args) {
        int A=6;
        int[] dp=new int[A+1];
        Arrays.fill(dp,-1);
        //System.out.println(climbStairsMain(A,dp));
        //System.out.println(countMinSquares(A,dp));
        //System.out.println(Arrays.toString(dp));
        int[][] grid={{16,5,54,55,36,82,61,77,66,61},{31,30,36,70,9,37,1,11,68,14}};
        //System.out.println(Arrays.toString(convert(grid)));
        adjacent(grid);
    }
    public static int adjacent(int[][] A){
        int[] oneD=convert(A);
        System.out.println(Arrays.toString(oneD));
        adj(oneD);
        return 0;
    }
    public static int adj(int[] A){
        int[] ans=A;
        for(int i=1; i<A.length;i++){
            if(i==1) ans[i]=Math.max(ans[i-1],A[i]);
            else ans[i]=Math.max(ans[i-1],ans[i-2]+A[i]);
        }
        int res=ans[0];
        for(int i=1; i<ans.length;i++) if(ans[i]>res) res=ans[i];
        System.out.println("Main Answer: "+Arrays.toString(ans));
        return res;
    }
    public static int[] convert(int[][]A){
        int M=A[0].length;
        int[] ans=new int[M];
        for(int i=0;i<M;i++) ans[i]=Math.max(A[0][i],A[1][i]);
        return ans;
    }
    public static int countMinSquares(int A, int[] dp){
        if(dp[A] !=-1) return dp[A];
        if(A==0) return 0;
        int temp=Integer.MAX_VALUE;
        for(int i=1; i*i<=A;i++){
            temp=Math.min(temp,countMinSquares(A-(i*i),dp));
        }
        dp[A]=temp+1;
        return dp[A];
    }

    public static int climbStairsMain(int A, int[] dp){
        if(dp[A] !=-1) return dp[A];
        if(A<=2) return A;
        dp[A]= climbStairsMain(A-1,dp)+climbStairsMain(A-2,dp);
        return dp[A];
    }
}
