package org.leetcode;

import java.util.Arrays;

public class SeptemberOne {
    static int pathSum=0;
    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        int[][] vis=new int[3][3];
        System.out.println(minPathSum(grid,0,0,3,3));

    }
    public static boolean minPathSum(int[][] grid,int i, int j, int N, int M){
        System.out.println("i: "+i+" j: "+j);
        if(i==N || j==M) return false;
        if(i==N-1 && j==M-1){
            System.out.println("Success");
            return true;
        }

        boolean right=minPathSum(grid, i, j+1, N, M);
        boolean down=minPathSum(grid, i+1,j, N,M);
        return right||down;
    }
}
