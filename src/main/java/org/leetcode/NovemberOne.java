package org.leetcode;

import org.amadeus.oops.polymorphism.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NovemberOne {
    public static void main(String[] args) {
        char[] chars={'a','b','c'};
        //char[] ans=new char[3];
        int[] vis={0,0,0};
        int idx=0;
        //permute(chars,ans,vis,idx);
        int[] arr={1,2};
        ArrayList<Integer> ans=new ArrayList<>();
        //subset(arr,0,ans);
    }
    public String[] findRestaurant(String[] list1, String[] list2){
        ArrayList<String> result=new ArrayList<>();
        int lowSum=Integer.MAX_VALUE;
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<list2.length;i++){
            map.put(list2[i],i);
        }
        for(int i=0;i<list1.length;i++){
            String curr=list1[i];
            if(map.containsKey(curr)){
                int tempAns=i+map.get(curr);
                if(tempAns<lowSum){
                    lowSum=tempAns;
                    result=new ArrayList<>();
                    result.add(curr);
                }
                else if( tempAns==lowSum) result.add(curr);
            }
        }
        return result.toArray(new String[0]);
    }
    private static void subset(int[] arr, int idx, ArrayList<Integer>ans){
        if(idx==arr.length){
            System.out.println(ans);
            return;
        }
        subset(arr, idx+1, ans);
        ans.add(arr[idx]);
        subset(arr, idx+1, ans);
        ans.remove(ans.size()-1);
    }
    private static void permute(char[] chars, char[] ans, int[] vis, int idx){
        if(idx==3){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<3; i++){
            if(vis[i]==0){
                vis[i]=1;
                ans[idx]=chars[i];
                permute(chars, ans, vis, idx+1);
                vis[i]=0;
            }
        }
    }
}
