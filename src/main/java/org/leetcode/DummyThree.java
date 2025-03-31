package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class DummyThree {
    public static void main(String[] args) {
        int[] nums={1,2,5,25};
        int target =100;
        HashMap<Integer, Integer> memo=new HashMap<>();
        //ArrayList<Integer> answer= howSum(nums,target, memo);
        //System.out.println(answer);
        //System.out.println(minMovesToTarget(nums,target,memo));
        String word="abcdef";
        String[] dict={"ab","abc","cd","def","abcd"};
        HashMap<String,Boolean> map=new HashMap<>();
        //System.out.println(canConstruct(word,dict,map));
        //System.out.println(canCon(word,dict,map));
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        System.out.println(count(word,dict,ans));
        System.out.println(ans);

    }
    private static ArrayList<String> count(String word, String[] dict,ArrayList<ArrayList<String>> ans){
        if(word.length()==0){
            ArrayList<String> str=new ArrayList<>();
            str.add("");
            return str;
        }
        ArrayList<String> a=new ArrayList<>();
        for(int i=0;i<dict.length;i++){
            String curr=dict[i];
            int index=word.indexOf(curr);
            if(index ==0) {
                String remaining=word.substring(index+curr.length());
                ArrayList<String> rem=count(remaining,dict,ans);
                ans.add(rem);
            }
        }
        //map.put(word,false);
        return a;
    }
    private static boolean canCon(String word, String[] dict,HashMap<String,Boolean> map){
        if(map.containsKey(word)) return map.get(word);
        System.out.println("Called for: "+word);
        if(word.length()==0) return true;
        for(int i=0;i<dict.length;i++){
            String curr=dict[i];
            int index=word.indexOf(curr);
            if(index !=-1) {
                String remaining=word.substring(index+curr.length());
                if(canCon(remaining,dict,map)){
                    map.put(word,true);
                    return true;
                }
            }
        }
        map.put(word,false);
        return false;
    }
    private static boolean canConstruct(String word, String[] dict,HashMap<String,Boolean> map){
        //System.out.println("Called for: "+word);
        if(map.containsKey(word)==true) return true;
        if(isPresent(word,dict)) {
            return true;
        }
        for(int i=0; i<=word.length();i++){
            String startsWith=word.substring(0,i);
            String remaining=word.substring(i);
            System.out.println(startsWith+" "+remaining);
            if(isPresent(startsWith,dict) && canConstruct(remaining,dict,map)){
                map.put(remaining,true);
               return true;
            }
        }
        map.put(word,false);
        return false;
    }
    private static boolean isPresent(String target, String[] dict){
        for(int i=0; i<dict.length;i++){
            if(target.equals(dict[i])) return true;
        }
        return false;
    }
    private static int minMovesToTarget(int[] nums, int target,HashMap<Integer, Integer> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0) return 0;
        if(target<0) {
            memo.put(target,Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        };
        int compare=Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++){
            int res=minMovesToTarget(nums,target-nums[i],memo);
            if(res !=Integer.MAX_VALUE) {
                compare = Math.min(compare, res + 1);
                memo.put(target,compare);
            }
        }
        memo.put(target,compare);
        return compare;
    }
    private static ArrayList<Integer> howSum(int[] nums, int target,HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0){
            return new ArrayList<>();
        }
        if(target<0) return  null;
        for(int i=0; i<nums.length;i++){
            ArrayList<Integer> temp= howSum(nums,target-nums[i],memo);
            if(temp !=null){
                temp.add(nums[i]);
                memo.put(target,temp);
                return temp;
            }
        }
        memo.put(target,null);
        return null;
    }
}
