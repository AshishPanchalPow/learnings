package org.leetcode;

import java.util.Arrays;

public class Delete {
    public static void main(String[] args) {
        int[][] maze={
                {0,0,1,0,0},
                {0,0,1,0,1},
                {1,0,0,0,1},
                {0,1,0,0,0},
                {0,0,1,1,0},
        };
        int N=maze.length;
        int M=maze[0].length;
        int[][] vis=new int[N][M];
        //System.out.println(reachEnd(maze,vis,N,M,0,0));
        char[] arr={'a','b','a'};
        int[] visited={0,0,0};
        char[] ans=new char[3];
        //permute(arr,visited,ans,0);
        int [] nums={1,2,3};
        String answer="";
        int idx=0;
        subset(nums, answer, idx);
    }

    private static void subset(int[] nums, String answer, int idx) {
        if(idx==3){
            System.out.println(answer);
            return;
        }
        for(int i=0; i<3; i++){
            subset(nums, answer, idx+1);
            answer +=nums[i];
            //subset(nums, answer, idx+1);
        }
    }

    private static void permute(char[] arr, int[] visited, char[] ans, int idx){
        if(idx==3){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<3; i++){
            if(visited[i]==0){
                visited[i]=1;
                ans[idx]=arr[i];
                permute(arr, visited,ans,idx+1);
                visited[i]=0;
            }
        }
    }
    private  static boolean reachEnd(int[][]maze, int[][] vis, int N, int M, int i, int j){
        if(i==N-1 && j==M-1){
            System.out.println("Success");
            return true;
        }
        vis[i][j]=2;
        if(canGo(maze,vis,N,M,i,j+1) && reachEnd(maze,vis,N,M,i,j+1)){
            return true;
        }
        if(canGo(maze,vis,N,M,i,j-1) && reachEnd(maze,vis,N,M,i,j-1)){
            return true;
        }
        if(canGo(maze,vis,N,M,i+1,j) &&reachEnd(maze,vis,N,M,i+1,j)){
            return true;
        }
        if(canGo(maze,vis,N,M,i-1,j) && reachEnd(maze,vis,N,M,i-1,j)){
            return true;
        }
        vis[i][j]=0;
        return false;

    }
    private static boolean canGo(int[][] maze, int[][]vis, int N, int M, int i, int j){

        if(i<0 || i==N || j<0 || j==M || vis[i][j]==2 || maze[i][j]==1){
            return false;
        }
        return true;
    }
}
