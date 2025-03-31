package org.advanced.partFour;

import org.amadeus.oops.polymorphism.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BackTrackingOne {
    static int mainAns=0;
    static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        int[][] maze={
                {0,0,1},
                {1,0,1},
                {1,1,0},
        };
        //System.out.println(ratInMaze(maze,0,0));
        char[] chars={'a','b','c'};
        String ans="";
        //permutations(chars,0,ans);
        int[][] A=  {{1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}};

        int startingIndexX=startingIndex(A)[0];
        int startingIndexY=startingIndex(A)[1];
        int N=A.length;
        int M=A[0].length;
        int[][] vis=new int[N][M];
        ArrayList<ArrayList<Integer>> allPaths=new ArrayList<>();
        int obstacles=countMinusOnes(A);
        //solve(A,vis, startingIndexX, startingIndexY, N,M,allPaths,obstacles);
        //System.out.println(mainAns);
        char[] array={'a','a','b'};
        int len=array.length;
        int[] visited=new int[len];
        char[] answer=new char[len];
        //permute(array,visited,0, len,answer);
        int[] numbers={1,2,3};
        Map<Integer,Integer> freq=new HashMap<>();
        for(int num: numbers){
            if(freq.containsKey(num)){
                int f=freq.get(num);
                f++;
                freq.put(num,f);
            }
            else freq.put(num,1);
        }
        int size=numbers.length;
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<ArrayList<Integer>> main=new ArrayList<>();
        permuteUnique(numbers,freq,result,size,0);
        System.out.println(res);
    }
    private static void permuteUnique(int[] A,Map<Integer,Integer> freq,ArrayList<Integer> result, int N, int idx){
        if(idx==N){
            //System.out.println("Answer found");
            System.out.println(result);
            //res.add(result);
            return ;
        }
        for(Integer key: freq.keySet()){
            if(freq.get(key)>0){
                int f=freq.get(key);
                f--;
                freq.put(key,f);
                result.add(idx,key);
                permuteUnique(A,freq,result,N,idx+1);
                int fr=freq.get(key);
                fr++;
                freq.put(key,fr);
                result.remove(idx);
            }
        }
    }
    private static void permute(char[] A, int[] vis, int index, int N,char[] ans){
        if(index==N){
            System.out.println(Arrays.toString(ans));
            return;
        }
        for(int i=0; i<N; i++){
            if(vis[i]==0){
                vis[i]=1;
                ans[index]=A[i];
                permute(A,vis,index+1,N, ans);
                vis[i]=0;
            }
        }
    }

    private static boolean solve(int[][] A, int[][] vis, int i, int j, int n, int m, ArrayList<ArrayList<Integer>> allPaths,int obstacles) {
        if(A[i][j]==2){
            //System.out.println("Success");
            System.out.println(allPaths);
            if(allPaths.size()+1+obstacles==n*m) mainAns++;
            return true;
        }
        vis[i][j]=3;
        ArrayList<Integer> path=new ArrayList<>();
        path.add(i);
        path.add(j);
        allPaths.add(path);
        //R
        if(canGo(A,vis,n,m,i,j+1)){
             solve(A,vis,i,j+1,n,m,allPaths,obstacles);

        }
        //L
        if(canGo(A,vis,n,m,i,j-1) ){
             solve(A,vis,i,j-1,n,m,allPaths,obstacles);
        }
        //T
        if(canGo(A,vis,n,m,i-1,j)  ){
             solve(A,vis,i-1,j,n,m,allPaths,obstacles);
        }
        //B
        if(canGo(A,vis,n,m,i+1,j)  ){
             solve(A,vis,i+1,j,n,m,allPaths,obstacles);
        }
        vis[i][j]=0;
        allPaths.remove(allPaths.size()-1);
        return false;
    }
    private static boolean canGo(int[][] A, int[][]vis, int N, int M, int i, int j){

        if(i<0 || i==N || j<0 || j==M || vis[i][j]==3 || A[i][j]==-1){
            return false;
        }
        return true;
    }

    private static int[] startingIndex(int[][]A){
        int[] ans=new int[2];
        for(int i=0; i<A.length;i++){
            for(int j=0; j<A[0].length;j++) if(A[i][j]==1) ans= new int[]{i, j};
        }
        return ans;
    }
    private static int countMinusOnes(int[][]A){
        int ans=0;
        for(int i=0; i<A.length;i++){
            for(int j=0; j<A[0].length;j++) if(A[i][j]==-1) ans++;
        }
        return ans;
    }
    public static void permutations(char[] chars, int index, String ans){
        if(index==3){
            System.out.println(ans);
            return;
        }
        ans +=chars[index];
        permutations(chars,index+1,ans);


    }
    public static boolean ratInMaze(int[][] maze, int i, int j){
        if(i==maze.length-1 && j==maze[0].length-1){
            return true;
        }
        if(isValid(maze,i,j)){
            maze[i][j]=2;
            if(ratInMaze(maze,i,j+1)){
                return true;
            }
            if(ratInMaze(maze,i,j-1)){
                return true;
            }
            if(ratInMaze(maze,i+1,j)){
                return true;
            }
            if(ratInMaze(maze,i-1,j)){
                return true;
            }
            maze[i][j]=0;
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int i, int j) {
        int N=maze.length; int M=maze[0].length;
        if(i>=0 && i<N && j>=0 && j<M && maze[i][j]==0) return true;
        return false;
    }

}
