package leetcode;

import java.util.*;

public class PartFive {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=100;
        Map<Integer,Integer> map =new HashMap<>();
        int[]nums={1,2,3};
        //System.out.println("Final Answer:"+letterCasePermutation("C"));
        ArrayList<Integer> answer=new ArrayList<>();
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        subset(nums,0,answer,result);
        return result;
    }
    public static List<Integer> subset(int[] nums, int index, List<Integer> answer,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(answer));
            System.out.println(answer);
            return answer;
        }
            //Do not pick
        subset(nums,index+1,answer,result);
        answer.add(nums[index]);
        subset(nums,index+1,answer,result);
        answer.remove(answer.size()-1);
        return answer;
    }
    public static List<String> letterCasePermutation(String s) {
        List<Character> ans=new ArrayList<>();
        List<String> result=new ArrayList<>();
        s=s.toLowerCase();
        permute(s,0,ans,result);
        return result;
    }
    public static String convert(List<Character> ans){
        StringBuilder sb = new StringBuilder();
        for (char ch : ans) {
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void permute(String s,int index,List<Character> ans, List<String> result) {
        if(ans.size()==s.length()) {
            System.out.println("Answer complete: "+ans);
            result.add(convert(ans));
            return;
        }

        if(Character.isAlphabetic(s.charAt(index))){
            ans.add(index,s.charAt(index));
            permute(s,index+1,ans,result);
            ans.remove(ans.size() - 1);
            ans.add(index,Character.toUpperCase(s.charAt(index)));
            permute(s,index+1,ans,result);
            ans.remove(ans.size() - 1);
        }
        else {
            ans.add(index,s.charAt(index));
            permute(s,index+1,ans,result);
            ans.remove(ans.size() - 1);
        }
    }
    public int[] countBits(int n) {
        int[] answer=new int[n+1];
        answer[0]=0;
        for(int i=1; i<=n;i++) answer[i]=countBitsForANumber(i);
        return answer;
    }
    public static int countBitsForANumber(int n){
        int ans=0;
        while(n>0){
            if((n&1)==1) ans++;
            n=n>>1;
        }
        return ans;
    }
    public static int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int runningSum=nums[0];
        for(int i=1; i<nums.length;i++){

            if(runningSum<0){
                runningSum=0;
            }
            runningSum +=nums[i];
            maxSum=Math.max(maxSum,runningSum);
        }
        return maxSum;
    }
    public static int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static int _coin(int[] coins, int amount, Map<Integer,Integer> map ) {
        if(map.containsKey(amount)) return map.get(amount);
        if(amount==0){
            map.put(0,0);
            return 0;
        }
        if(amount<0) {
            map.put(amount,Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        int answer=Integer.MAX_VALUE;
        for(int i=0; i<coins.length;i++){
            int localAnswer=_coin(coins,amount-coins[i],map);
            if(localAnswer!=Integer.MAX_VALUE) {
                localAnswer++;
                answer=Math.min(answer,localAnswer);
            }
        }
        map.put(amount,answer);
        return answer;
    }
}
