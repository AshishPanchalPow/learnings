package org.leetcode;

import java.util.HashMap;

public class JanuaryTwo {
    public static void main(String[] args) {
        int[] weights={3,4,7};
        int[] happiness={2,3,5};
        int capacity=9005;
        HashMap<Integer,Integer> memo=new HashMap<>();
        //System.out.println(maxHappiness(weights,happiness,capacity,memo));
        int N=5;
        int[] prices={0,1,4,2,5,6};
        //System.out.println(maxSale(N,prices));
        int K=5;
        int[] coins={3,1,4};
        System.out.println(uniqueWays(K,coins,0));
    }
    private static int uniqueWays(int K, int[] coins, int index){
        if(K==0){
            return 1;
        }
        if(K<0){
            return 0;
        }

        int unique=0;
        for(int i=index; i<coins.length; i++){
            int currCoin=coins[i];
            unique +=uniqueWays(K-currCoin,coins,i);

        }
        return unique;
    }
    private static int ways(int K, int[] coins){
        if(K==0){
            return 1;
        }
        if(K<0){
            return 0;
        }
        int noOfWays=0;
        for(int i=0; i<coins.length;i++){
            noOfWays +=ways(K-coins[i],coins);
        }
        return noOfWays;

    }
    private static int maxSale(int N, int[] prices){
        if(N<=0){
            return prices[0];
        }
        int maxAns=0;
        for(int i=1;i<=N;i++){
            int cutlength=i;
            int gainedprice=prices[i];
            gainedprice +=maxSale(N-cutlength,prices);
            if(gainedprice>maxAns) maxAns=gainedprice;
        }
        return maxAns;

    }
    public static int maxHappiness(int[] weights, int[] happiness, int capacity,HashMap<Integer,Integer> memo){
        if(memo.containsKey(capacity)) return memo.get(capacity);
        if(capacity<=0){
            memo.put(capacity,0);
            return 0;
        }
        int maxHappy=0;
        for(int i=0;i<3; i++){
            int localHappy=0;
            int currWeight=weights[i];
            if(currWeight<=capacity){
                localHappy =happiness[i]+maxHappiness(weights,happiness, capacity-currWeight,memo);
            }
            if(localHappy>maxHappy)maxHappy=localHappy;
        }
        memo.put(capacity,maxHappy);
        return maxHappy;
    }
}
