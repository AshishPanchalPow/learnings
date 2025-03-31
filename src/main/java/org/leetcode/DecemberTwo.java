package org.leetcode;

import java.util.Arrays;

public class DecemberTwo {
    public static void main(String[] args) {
        int[][] A={
                {1,-3,2},
                {2,5,10},
                {5,-5,1}
        };
        //System.out.println(minPathSum(A,0,0,3,3));
        //System.out.println("Hello".substring(2,5));
        //System.out.println(numDecodings("11106"));
        //System.out.println(Arrays.to);
        String message="And ... .... is my secret";
        String[] messages=message.split(" ");
        System.out.println(solve(messages,0,16));

    }
    public static String solve(String[] messages, int idx, int K){
        if(messages[idx].length()>=K && idx <= messages.length-1){
            return "...";
        }
        String ans=messages[idx];
        if(ans.length()+4<=K){
            return ans+" "+solve(messages,idx+1,K-ans.length()-1);
        }
        return "...";
    }
    public static int minPathSum(int[][] A, int curX, int curY, int N, int M) {
        if(curX==N-1 && curY==M-1){
            return A[curX][curY];
        }
        if(curX==N || curY==M){
            return Integer.MAX_VALUE;
        }
        int rSum=minPathSum(A,curX,curY+1,N,M);
        int dSum=minPathSum(A,curX+1,curY,N,M);
        return A[curX][curY]+Math.min(rSum,dSum);
    }
}
