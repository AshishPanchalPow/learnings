package scaler.threetopics;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestOne {
    public static void main(String[] args) {
        int[] nums={2,3,0,1,4,0,0,0,0,0};
        //System.out.println(jump(nums,0));
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int ans=1;
        if(s.length()<2) return s.length();
        int left=0;
        int right=0;
        Set<Character> set=new HashSet<>();
        while (right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(right));
                left++;
            }
            else {
                set.add(s.charAt(right));
                ans= Math.max(ans,right-left+1);
                right++;
            }
        }
        return ans;
    }
    public static int jump(int[] nums, int currIdx) {
        if(currIdx>=nums.length-1){
            return 0;
        }
        int base=nums[currIdx];
        if(base==0){
            return Integer.MAX_VALUE;
        }
        int minJumps=Integer.MAX_VALUE;
        for(int i=1;i<=base;i++ ){
            int curr=currIdx+i;
            int localJumps=jump(nums, curr);
            if(localJumps !=Integer.MAX_VALUE){
                localJumps+=1;
                minJumps=Math.min(minJumps,localJumps);
            }
        }
        return minJumps;
    }
}
