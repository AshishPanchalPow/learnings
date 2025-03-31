package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PartTwo {
    public static void main(String[] args) {
        int[][] intervals={{10,20},{30,40}};
        int[] newInterval={4,8};
        insert(intervals,newInterval);
        //merge(intervals);
    }
    private static int solve(String A){
        // If full palindrome then 1 else answer is 2.
        int ans=0;
        ans=isPalindrome(A)?1:2;
        return ans;
    }
    public static boolean isPalindrome(String s) {
        if(s.length()%2==0){
            int mid1=(s.length()-1)/2;
            int mid2=mid1+1;
            while(mid1>=0 && mid2<=s.length()-1){
                if(s.charAt(mid1)!=s.charAt(mid2)){
                    return false;
                }
                else{
                    mid1--;
                    mid2++;
                }
            }
        }
        else{
            int mid=s.length()/2;
            int l=mid; int r=mid;
            while (l>0 && r<s.length()-1){
                if(s.charAt(l-1)!=s.charAt(r+1)){
                    return false;
                }
                else {
                    l--;
                    r++;
                }
            }
        }
        return true;
    }
    public static int[][] insert(int[][] intervals, int[] newInterval){
        int N=intervals.length;
        int[][] answer=new int[N+1][2];
        int insert_index=0;
        for(int i=0; i<N; i++){
            if(newInterval[0]>intervals[i][1]){
                //Simply add to answer.
                answer[insert_index]=intervals[i];
                insert_index++;
            }
            else if(newInterval[1]<intervals[i][0]){
                answer[insert_index]=newInterval;
                insert_index++;
                for(int j=i;j<intervals.length;j++){
                    answer[insert_index]=intervals[j];
                    insert_index++;
                }
                int[][] mainAns=new int[insert_index][2];
                for(int k=0; k<insert_index;k++){
                    mainAns[k]=answer[k];
                }
                return mainAns;
            }
            else{
                //Overlap
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
        }
        answer[insert_index]=newInterval;
        insert_index++;
        int[][] mainAns=new int[insert_index][2];
        for(int i=0; i<insert_index;i++){
            mainAns[i]=answer[i];
        }
        return mainAns;
    }
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(intervals);
        int N= intervals.length;
        int[][] ans=new int[N][2];
        ArrayList<ArrayList<Integer>> answer=new ArrayList<>();
        int insert_idx=-1;
        int i=0;
        while(i<N){
            int[] curr=intervals[i];
            while(i<N-1 && checkOverlap(curr,intervals[i+1])){
                curr[0]=Math.min(curr[0],intervals[i+1][0]);
                curr[1]=Math.max(curr[1],intervals[i+1][1]);
                i++;
            }
            i++;
            insert_idx++;
            ans[insert_idx]=curr;
        }
        System.out.println(insert_idx);
        int[][] mainAns=new int[insert_idx+1][2];
        for(int j=0; j<=insert_idx;j++){
            mainAns[j]=ans[j];
        }
        System.out.println(mainAns);
        return ans;
    }
    public static boolean checkOverlap(int[] int1, int[] int2){
        int l1=int1[0];
        int r1=int1[1];
        int l2=int2[0];
        int r2=int2[1];
        //if(l2<r1 )
        return false;
    }
}
