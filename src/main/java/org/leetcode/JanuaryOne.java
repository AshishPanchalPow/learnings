package org.leetcode;

import java.util.ArrayList;
import java.util.Map;

public class JanuaryOne {
    public static void main(String[] args) {
        System.out.println("Hi");
        int[] values={100,60,120,150};
        int[] weights={20,10,30,40};
        int K=50;
        int[] arr={1,2,3};
        ArrayList<Integer> ans=new ArrayList<>();
        //printSubSets(values,0,ans);
        System.out.println(kp(values,weights,0,K));
    }
    public static int kp(int[]values, int[] weights,int index, int capacity) {
        if (index == 4 || capacity <= 0) {
            return 0;
        }
        int valNotPick = kp(values, weights, index+1, capacity);
        int valPick = 0;
        if (capacity >= weights[index]) {
            valPick = values[index] + kp(values, weights, index, capacity - weights[index]);
        }
        return Math.max(valNotPick, valPick);
    }
    public static void printSubSets(int[] arr, int idx, ArrayList<Integer> ans){
        if(idx==arr.length){
            System.out.println(ans);
            //System.out.println(ans.stream().mapToInt(Integer::intValue).sum());
            return;
        }
        printSubSets(arr,idx+1,ans);
        ans.add(arr[idx]);
        printSubSets(arr,idx+1,ans);
        ans.remove(ans.size()-1);

    }
    public static int pick(int[] values, int[] weights, int K, int index){
        if(index==4){
            return 0;
        }
        for(int i=0; i<4; i++){
            int skipCurr=pick(values,weights,K,index+1);

        }
        return 0;
    }

}
