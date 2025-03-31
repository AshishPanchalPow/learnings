package org.leetcode;

import java.util.Arrays;

public class JanuaryFour {
    public static void main(String[] args) {
        System.out.println("Hi");
        String sequence="aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word="aaaba";
//        String sequence="a";
//        String word="a";
        //System.out.println(maxRepeating(sequence,word));
        String str="aacabdkacaa";
        StringBuilder stringBuilder=new StringBuilder(str);
        String revStr=stringBuilder.reverse().toString();
        //System.out.println(longestPalindrome(str,revStr,0,0));
        System.out.println(Arrays.deepToString(fillDP("abcba")));
    }
    private static boolean[][] fillDP(String s){
        int N=s.length();
        boolean[][] dp=new boolean[N][N];
        for(int i=0; i<N-1;i++){
            for(int j=0; j<N; j++){
                if(i==j) dp[i][j]=true;
                else if(i-j==-1){
                    dp[i][j]=s.charAt(i) == s.charAt(j);;
                }
            }
        }
        //int ans=0;
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                int diagonal=(i-j);
                if(diagonal<0) {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (diagonal<-1) {
                        dp[i][j]= b &&dp[i+1][j-1];
                    }
                }

            }
        }
        //System.out.println("Ans: "+ans);
        return dp;
    }
    public static String longestPalindrome(String str,String revStr,  int i, int j) {
        if(i==str.length() || j==str.length()){
            return "";
        }
        String ans="";
        if(str.charAt(i)==revStr.charAt(j)){
            ans +=str.charAt(i);
            ans +=longestPalindrome(str,revStr,i+1,j+1);
        }
        else{
            String ans1=longestPalindrome(str,revStr,i,j+1);
            String ans2=longestPalindrome(str,revStr,i+1,j);
            ans=ans1.length()>ans2.length()?ans1:ans2;
        }


        return ans;
    }

    private static int maxRepeating(String sequence, String word) {
        // Initialize the repetition count
        int count = 0;
        // Build the repeated word and check if it's a substring of sequence
        String repeatedWord = word;
        while (sequence.contains(repeatedWord)) {
            count++;
            repeatedWord += word; // Add another repetition of word
        }
        return count;
    }

    public static int maxRepeatingw(String sequence, String word) {
        if(sequence.length()<word.length()){
            return 0;
        }
        int k=0;
        int localMax=0;
        int pick=0;
        int notPick=0;
        for(int i=0; i<word.length();i++){
            if(i+word.length()<sequence.length()){
                String partOne=sequence.substring(i,i+word.length());
                if(partOne.equals(word)){
                    pick=1+maxRepeating(sequence.substring(i+word.length()),word);
                }
                else{
                    notPick=maxRepeating(sequence.substring(i+word.length()),word);
                }
            }
        }
        k=Math.max(pick,notPick);
        return k;
    }
}
