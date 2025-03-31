package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DecemberOne {
    public static void main(String[] args) {
        System.out.println("Hi");
        /*System.out.println(generate(39));
        HashMap<Integer, List<Integer>> memo=new HashMap<>();
        System.out.println(getRow(1,memo));
        int[] cost={10,15,20};
        int N=cost.length;
        HashMap<Integer,Integer> memo=new HashMap<>();
        System.out.println(minCostClimbingStairs(cost,N,memo));
        String s = "aaabb", t = "bba";
        System.out.println(isSubsequence(s,t,0));
        int[] gold={2,18,10,3,15,7};
        HashMap<Integer,Integer> memo=new HashMap<>();
        System.out.println(maxTheft(gold,0,gold.length,memo));
        int[][] grid={
                {0,0,0,0},
                {0,1,0,1},
                {0,0,0,0},
                {1,0,1,0}
        };
        int curX=0; int curY=0;
        int rowMax=grid.length;
        int colMax=grid[0].length;
        System.out.println(countWays(grid,curX,curY,rowMax,colMax));*/
        int[][] maze={
                {-3,2,4,-5},
                {-6,5,-4,6},
                {-5,-7,5,-2},
                {2,10,-3,-4}
        };
//        int[][] maze={
//                {-2,-8,100},
//                {-1,-3,1}
//        };
        int curX=0; int curY=0; int rowMax=maze.length;int colMax=maze[0].length;
        System.out.println(minHealth(maze,curX,curY,rowMax,colMax));
    }
    private static int minHealth(int[][]grid, int curX, int curY, int rowMax, int colMax){
        if(curX==rowMax-1 && curY==colMax-1){
            if(grid[curX][curY]>0) return 0;
            else return 0-grid[curX][curY]+1;
        }
        if(curX==rowMax || curY==colMax){
            return Integer.MAX_VALUE;
        }
        int goingRight=minHealth(grid,curX,curY+1,rowMax,colMax);
        int goingDown=minHealth(grid,curX+1,curY,rowMax,colMax);
        if(curX==0&& curY==0){
            System.out.println("SOmething");
        }
        if(goingDown>0 && goingRight>0){
            int min=Math.min(goingRight,goingDown);
            if(grid[curX][curY]>0) return min;
            else return 0-grid[curX][curY]+min+1;
        }
        else if(goingDown>0){
            if(grid[curX][curY]>0) return 0;
            else return 0-grid[curX][curY]+1;
        }
        else if(goingRight>0){
            if(grid[curX][curY]>0) return 0;
            else return 0-grid[curX][curY]+1;
        }
        else{
            int min=Math.min(0-goingRight,0-goingDown);
            if(grid[curX][curY]>0) return min;
            else return 0-grid[curX][curY]+min+1;
        }

    }
    private static int countWays(int[][]grid, int curX, int curY, int rowMax, int colMax){
        if(curX==rowMax-1 && curY==colMax-1){
            return 1;
        }
        if(curX==rowMax || curY==colMax || grid[curX][curY]==1){
            return 0;
        }
        int waysByGoingRight=countWays(grid,curX,curY+1,rowMax,colMax);
        int waysByGoingDown=countWays(grid,curX+1,curY,rowMax,colMax);
        return waysByGoingRight+waysByGoingDown;
    }
    private static int maxTheft(int[] gold, int idx, int N,HashMap<Integer,Integer> memo){

        if(memo.containsKey(idx)) return memo.get(idx);
        System.out.println("Called for idx: "+idx);
        if(idx==N-1){
            memo.put(idx,gold[idx]);
            return gold[idx];
        }
        if(idx>=N){
            return 0;
        }
        int pickFirst=maxTheft(gold,idx+1,N,memo);
        int pickSecond=maxTheft(gold,idx+2,N,memo);
        int ans=Math.max(gold[idx]+pickSecond,pickFirst);
        memo.put(idx,ans);
        return ans;
    }
    public static boolean isSubsequence(String s, String t, int index) {
        if(index==s.length()) return true;
         for(int i=index; i<s.length();i++){
            int firstIdxOfI=t.indexOf(s.charAt(i));
            if(firstIdxOfI !=-1){
                t=t.substring(firstIdxOfI+1);
                return isSubsequence(s,t,index+1);
            }
            return false;
        }
        return false;
    }
    public static int minCostClimbingStairs(int[] cost,int idx,HashMap<Integer,Integer> memo ) {
        if(memo.containsKey(idx))return memo.get(idx);
        if(idx<=1){
            return cost[idx];
        }
        int topMinusOne=minCostClimbingStairs(cost, idx-1,memo);
        int topMinusTwo=minCostClimbingStairs(cost,idx-2,memo);
        int costTillHere=idx==cost.length?Math.min(topMinusOne,topMinusTwo):Math.min(topMinusOne,topMinusTwo)+cost[idx];
        memo.put(idx,costTillHere);
        return costTillHere;
    }
    public static List<Integer> getRow(int rowIndex,HashMap<Integer, List<Integer>> memo) {
        if(memo.containsKey(rowIndex)) return memo.get(rowIndex);
        if(rowIndex==0){
            List<Integer> basic=new ArrayList<>();
            basic.add(1);
            memo.put(rowIndex,basic);
            return basic;
        }
        List<Integer> nTh=getRow(rowIndex-1,memo);
        List<Integer> running=new ArrayList<>();
        List<Integer> prev=nTh;
        for(int i=0; i<=rowIndex;i++){
            if(i==0 || i==rowIndex)running.add(i,1);
            else{
                running.add(prev.get(i)+prev.get(i-1));
            }
        }
        memo.put(rowIndex,running);
       return running;

    }
    private static List<List<Integer>> generate(int numRows) {
        if(numRows==1){
            List<Integer> basic=new ArrayList<>();
            basic.add(1);
            List<List<Integer>> res=new ArrayList<>();
            res.add(basic);
            return res;
        }
        List<List<Integer>> nTh=generate(numRows-1);
        List<Integer> running=new ArrayList<>();
        int sizeOfPrev=nTh.size();
        List<Integer> prev=nTh.get(sizeOfPrev-1);
        for(int i=0; i<numRows;i++){
            if(i==0 || i==numRows-1)running.add(i,1);
            else{
                running.add(prev.get(i)+prev.get(i-1));
            }
        }
        nTh.add(running);
        return nTh;
    }
}
