package org.leetcode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class NovemberTwo {
    public static void main(String[] args) {
        int N=6;
        int[] dp={-1,-1,-1,-1,-1,-1,-1};
        //System.out.println(fib(1,dp));
        //System.out.println(Arrays.toString(dp));
        ArrayList<String> ans=new ArrayList<>();
        //decode("21233",0);
        System.out.println("5126".substring(0,2));
    }
    private static int decodeDP(String A){
        int N=A.length();
        int[] dp=new int[N+1];
        if(N==0) return 0;
        if(A.equals("0")) return 0;
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<N; i++){
            //if(1<=Integer.parseInt(String.valueOf(A.charAt(i-1))))
        }



        return dp[N];
    }
    private static void decode(String A, int index){
        int N=A.length();
        if(index==A.length()-1){
            System.out.println("success");
            return;
        }
        if(index<N-1&&Integer.parseInt(A.substring(index, index+1))<27){
            decode(A, index+1);
        }
        if(index<N-2 &&Integer.parseInt(A.substring(index, index+2))<27){
            decode(A, index+2);
        }
        //return 0;
    }
    private static int fib(int N, int[] dp){
        if(N<2) return N;
        if(dp[N] !=-1) return dp[N];
        int x=fib(N-1,dp)+fib(N-2,dp);
        dp[N]=x;
        return dp[N];
    }
}
