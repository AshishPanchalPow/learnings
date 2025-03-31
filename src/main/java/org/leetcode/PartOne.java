package org.leetcode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PartOne {
    public static void main(String[] args) {
        System.out.println("I will finish 20 questions by Sunday");
        /*int[] nums={3,5,3};
        int target=6;
        twoSum(nums,target);
        String s="babad";
        lengthOfLongestSubstring(s);

        System.out.println(longestPalindrome("cbbd"));

        int[] height={1,3,2,5,25,24,5};
        System.out.println(maxArea(height)); */
        int[] nums={6,7,8};
        System.out.println(firstMissingPositive(nums));
        System.out.println("Problems done till now: "+6);
    }

    public static int firstMissingPositive(int[] nums){
        int N=nums.length;
        int i=0;
        while (i<N){
            if(nums[i]<=0 || nums[i]>N){
                i++;
            }
            else {
                int correct_idx=nums[i]-1;
                if(correct_idx==i){
                    i++;
                }
                else{
                    if(nums[correct_idx] !=nums[i]){
                        //swap
                        int temp=nums[correct_idx];
                        nums[correct_idx]=nums[i];
                        nums[i]=temp;
                    }
                    else{
                        i++;
                    }
                }
            }
        }

       for(int j=0; j<N;j++){
            if(nums[j] !=j+1){
                return j+1;
            }
       }
       return N+1;
    }
    public static int maxArea(int[] height){

        int N=height.length;
        int l=0; int r=N-1;
        int ans=Math.min(height[l],height[r])*r;
        while (l<r){
            if(height[l]<height[r]){
                l++;
            }
            else r--;
            ans=Math.max(ans,Math.min(height[l],height[r])*(r-l));
        }
        return ans;
    }
    public static String longestPalindrome(String s){
        String ans="";
        int N=s.length();
        for(int i=0; i<N; i++){
            for(int j=i+1;j<=N;j++){
                String str=s.substring(i,j);
                if(isPalindrome(str)){
                    if(str.length()>ans.length()){
                        ans=str;
                    }
                }
            }
        }
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
    // Let us code the N2 complexity first
    public static int lengthOfLongestSubstring(String s) {
        int ans=0;
        int l=0; int r=0;
        int N=s.length();
        if(N==1) return 1;
        HashSet<Character> hashSet=new HashSet<>();
        while (r<N){
            if(hashSet.contains(s.charAt(r))){
                ans=Math.max(ans, r-l);
                // move l till the curr element is present in hashset
                while(hashSet.contains(s.charAt(r))){
                    hashSet.remove(s.charAt(l));
                    l++;
                }
            }
            else{
                hashSet.add(s.charAt(r));
                r++;
            }
        }
        ans=Math.max(ans, r-l);
        //System.out.println("Longest substring: "+ans);
        return ans;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int curr=nums[i];
            if(hashMap.containsKey(target-curr)){
                ans[0]=i;
                ans[1]=hashMap.get(target-curr);
            }
            else{
                hashMap.put(curr,i);
            }
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }
}
