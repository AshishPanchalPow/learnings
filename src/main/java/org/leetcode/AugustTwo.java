package org.leetcode;

import java.util.*;

public class AugustTwo {
    static int global=0;
    public static void main(String[] args) {
        int[][] items={{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        //System.out.println(Arrays.toString(highFive(items)));
        //int[] nums={2,3,1,2,4,3};
        int target=7;
        //System.out.println(minSubArrayLen(target,nums));
        //int[][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board={{1,1},{1,0}};
        //gameOfLife(board);
        //System.out.println(firstUniqChar("loveleetcode"));
        //String[] code={"a/*comment", "line", "more_comment*/b"};
        //String[] code={"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        //String[] code={"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
        String[] code={"a//*b//*c","blank","d/*/e*//f"};
        //removeComments(code);
        int[] nums={-1,1,0,-3,3};
        productExceptSelf(nums);
        steps(6,0);
        System.out.println(global);
        int[] calculated=new int[6];
    }
    public static int steps(int N, int stepSize){
        //System.out.println("Steps available: "+N +" stepSize: "+stepSize);
        if(N==0) {
            global++;
            //System.out.println("Success");
            return 1;
        }
        if(N<0) return 0;
        int partOne=steps(N-1,1);
        return steps(N-1, 1)+steps(N-2,2);
    }
    public static int[] productExceptSelf(int[] nums){
        int N=nums.length;
        int[] ans=new int[N];
        int[] lProd=new int[N]; lProd[0]=nums[0];
        int[] rProd=new int[N]; rProd[N-1]=nums[N-1];
        for(int i=1; i<N; i++) lProd[i]=lProd[i-1]*nums[i];
        for(int j=N-2; j>=0; j--) rProd[j]=rProd[j+1]*nums[j];
        for(int i=0; i<N; i++){
            if(i==0){
                ans[i]=rProd[i+1];
            }
            else if(i==N-1){
                ans[i]=lProd[i-1];
            }
            else ans[i]=lProd[i-1]*rProd[i+1];
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
    public static List<String> removeComments(String[] source){
        List<String> ans=new ArrayList<>();
        for(int i=0; i<source.length;i++){
            String curr=source[i];
            if((curr.contains("//"))||(curr.contains("/*"))){
                String str="";
                //If single line comment
                if(curr.contains("//")){
                    str=curr.substring(0,curr.indexOf("//"));
                    if(str.length()!=0)ans.add(str);
                }
                //If multi line comment
                else if(curr.contains("/*")){
                    str=curr.substring(0,curr.indexOf("/*"));
                    while(!curr.contains("*/")){
                        i++;
                        curr=source[i];
                    }
                    if(!curr.endsWith("*/")){
                        str +=curr.substring(curr.indexOf("*/") + 2);
                    }
                    if(str.length()!=0)ans.add(str);
                }

            }
            else{
                ans.add(curr);
            }
        }
        System.out.println(ans);
        return ans;
    }
    private static void gameOfLife(int[][] board) {
        int N=board.length;
        int M=board[0].length;
        int[][] temp=new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                temp[i][j]=0;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==1){
                    int ones=countNeighbours(board,i,j,1);
                    if(ones==2 || ones==3) temp[i][j]=1;
                    else temp[i][j]=-1;
                }
                else{
                    int ones=countNeighbours(board,i,j,1);
                    if(ones==3) temp[i][j]=1;
                }

            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j]==1 && temp[i][j]==-1) board[i][j]=0;
                if(board[i][j]==0 && temp[i][j]==1) board[i][j]=1;
            }
        }
        System.out.println("Something");
    }
    private static int countNeighbours(int[][] board,int i, int j, int countWhat){
        int N=board.length;
        int M=board[0].length;
        int count=0;
        //Top
        if(i-1>=0 && board[i-1][j]==countWhat) count++;
        //Bottom
        if(i+1<N && board[i+1][j]==countWhat) count++;
        //Left
        if(j-1>=0 && board[i][j-1]==countWhat) count++;
        //Right
        if(j+1<M && board[i][j+1]==countWhat) count++;
        //Top Left
        if(i-1>=0 && j-1>=0&& board[i-1][j-1]==countWhat) count++;
        //Top Right
        if(i-1>=0 && j+1<M && board[i-1][j+1]==countWhat) count++;
        //Bottom left
        if(i+1<N && j-1>=0 && board[i+1][j-1]==countWhat) count++;
        //Bottom Right
        if(i+1<N && j+1<M && board[i+1][j+1]==countWhat) count++;

        return count;
    }

    public static int minSubArrayLen(int target, int[] nums){
        int N=nums.length;
        int minLength=N+10;
        int l=0; int r=0;
        int localSum=0;
        while(r<N){
            if(l==0 && r==0) localSum =nums[0];
            if(localSum>=target){
                minLength=Math.min(minLength,r-l+1);
                localSum -=nums[l];
                l++;
            }
            else{
                r++;
                if(r<N) localSum +=nums[r];
            }
        }

        return minLength==N+10?0:minLength;
    }
    public static int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scores=new HashMap<>();
        for(int i=0; i<items.length;i++){
            if(scores.containsKey(items[i][0])){
                scores.get(items[i][0]).add(items[i][1]);
            }
            else {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(items[i][1]);
                scores.put(items[i][0],list);
            }
        }

        int[][] ans=new int[scores.size()][2];
        //Extract the keys
        Integer[] students=scores.keySet().toArray(new Integer[0]);
        //Sort the scores
        for(int i=0; i<scores.size();i++){
            Collections.sort(scores.get(students[i]),Comparator.reverseOrder());
            int []scoreForStudent=new int[2];
            scoreForStudent[0]=students[i];
            scoreForStudent[1]=0;
            for(int j=0; j<5; j++){
                scoreForStudent[1] +=scores.get(students[i]).get(j);
            }
            scoreForStudent[1]=scoreForStudent[1]/5;
            ans[i]=scoreForStudent;
        }
        //System.out.println(ans);
        return ans;
    }
}
