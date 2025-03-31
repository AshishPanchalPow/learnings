package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DummyTwo {
    public static void main(String[] args) {
        //1 1 2 3 5 8 13 21 34 55
        int N=7;
        int[] memo=new int[N+1];
        //int res=fib(N,memo);
        //System.out.println(res>Integer.MAX_VALUE);
        int n=2; int m=3;
        long[][] gridMemo=new long[n][m];
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        //System.out.println(grid(0,0,n,m, gridMemo,paths));
        int[] nums={3,4,5,7};
        int target=2;
        HashMap<Integer, Boolean> memoized=new HashMap<>();
        ArrayList<Integer> answer=new ArrayList<>();
        System.out.println(canMakeTarget(target,nums, memoized,answer));
        System.out.println(answer);

    }
    private static boolean canMakeTarget(int target, int[] nums, HashMap<Integer, Boolean> memoized, ArrayList<Integer> answer){

        if(memoized.containsKey(target)) {

            return memoized.get(target);
        }
        if(target==0) return true;
        if(target<0) {
            if(answer.size()>0)answer.remove(answer.size()-1);
            return false;
        }
        for(int i=0; i<nums.length;i++){
            answer.add(nums[i]);
            boolean x= canMakeTarget(target-nums[i], nums,memoized,answer);

            memoized.put(target,x);
            if(x) return true;

        }
        memoized.put(target,false);
        if(answer.size()>0)answer.remove(answer.size()-1);
        return false;
    }
    private static long grid(int x, int y,int n, int m, long[][] gridMemo,ArrayList<ArrayList<Integer>>paths){
        ArrayList<Integer> path=new ArrayList<>();
        path.add(x);
        path.add(y);
        paths.add(path);
        if(x==n || y==m) {
            paths.remove(paths.size()-1);
            return 0;
        }

        if(gridMemo[x][y] !=0) return gridMemo[x][y];
        if(x==n-1 && y==m-1){
            //System.out.println("success");
            System.out.println(paths);
            paths.remove(paths.size() - 1);
            return 1l;
        }

        gridMemo[x][y]=grid(x+1,y,n,m, gridMemo,paths)+grid(x,y+1,n,m, gridMemo,paths);
        return gridMemo[x][y];
    }
    private static int fib(int N, int[] memo){
        if(memo[N] !=0) return memo[N];
        System.out.println("Called for N: "+N);
        if(N<=2) return 1;
        memo[N]=fib(N-1,memo)+fib(N-2,memo);
        return memo[N];

    }
    private static int fibBasic(int N){
        if(N<=2) return 1;
        return fibBasic(N-1)+fibBasic(N-2);
    }
}
