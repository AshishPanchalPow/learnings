package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DecemberThree {
    public static void main(String[] args) {
        String s="11106";
        /*HashMap<Integer,Integer> memo=new HashMap<>();
        //System.out.println(numDecodings(s,0,memo));
        //int[] prices={7,1,5,3,6,4};
        int[] prices={5,2,10};
        System.out.println(maxProfit(prices,0));
        int m=3; int n=7;
        int[][] memo=new int[m+1][n+1];
        System.out.println(uniquePaths(m,n,0,0,memo));*/
        int[][] costs={
                {3,5,3},
                {6,17,6},
                {7,13,18},
                {9,10,18}
        };
        int[][] memo=new int[costs.length+1][3];
        //System.out.println(minCost(costs,0,0, memo));
        int[] coins={2}; int amount=3;
        HashMap<Integer,Integer> coinMemo=new HashMap<>();
        int x=coinChange(coins,amount,coinMemo);
        System.out.println(x==Integer.MAX_VALUE?-1:x);
    }
    public static int coinChange(int[] coins, int amount,HashMap<Integer,Integer> coinMemo) {
        if(coinMemo.containsKey(amount)) return coinMemo.get(amount);
        if(amount==0){
            coinMemo.put(amount,0);
            return 0;
        }
        if(amount<0){
            coinMemo.put(amount,Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int minCoins=Integer.MAX_VALUE;
        for(int i=0; i<coins.length;i++){
            int currCoin=coins[i];
            int stepsFromCurr=coinChange(coins,amount-currCoin,coinMemo);
            if(stepsFromCurr !=Integer.MAX_VALUE){
                stepsFromCurr++;
                if(stepsFromCurr<minCoins){
                    minCoins=stepsFromCurr;
                }
            }
        }
        coinMemo.put(amount,minCoins);
        return minCoins;
    }
    public static int minCost(int[][] costs, int row, int col, int[][]memo) {
        if(memo[row][col] !=0) return memo[row][col];
        if(row==costs.length){
            memo[row][col]=0;
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int j=0; j<3; j++){
            if(j==col && row !=0){
                continue;
            }
            int currentCost = costs[row][j] + minCost(costs, row + 1, j,memo);
            minCost = Math.min(minCost, currentCost);
        }
        memo[row][col]=minCost;
        return minCost;

    }

    public static int uniquePaths(int m, int n, int x, int y, int[][] memo) {
        if(memo[x][y] !=0) return memo[x][y];
        if(x==m-1 && y==n-1) {
            memo[x][y]=1;
            return 1;
        }
        if(x==m || y==n) {
            memo[x][y]=0;
            return 0;
        }
        int goingDown=uniquePaths(m, n , x+1,y,memo);
        int goingRight=uniquePaths(m,n,x,y+1,memo);
        memo[x][y]=goingRight+goingDown;
        return goingDown+goingRight;
    }

    public static int maxProfit(int[] prices, int buyIndex) {
        if(buyIndex==prices.length-1){
            return 0;
        }
        int ans=0;
        for(int i=buyIndex;i<prices.length;i++){
            int profit=0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    int localProfit=maxProfit(prices,j+1)+prices[j]-prices[i];
                    System.out.println("For buying Index: "+i+"Profit: "+localProfit);
                    if(localProfit>profit) profit=localProfit;
                }
            }
            if(profit>ans) ans=profit;
        }

        return ans;
    }
    public static int numDecodings(String s, int index,HashMap<Integer,Integer> memo){
        if(memo.containsKey(index)) return memo.get(index);
        if(index==s.length()){
            memo.put(index,1);
            return 1;
        }
        if(s.charAt(index)=='0'){
            memo.put(index,0);
            return 0;
        }
        int ans=numDecodings(s,index+1,memo);
        if(index<s.length()-1){
            int second=Integer.parseInt(s.substring(index,index+2));
            if(second<=26){
                ans +=numDecodings(s,index+2,memo);
            }
        }
        memo.put(index,ans);
        return ans;
    }
}
