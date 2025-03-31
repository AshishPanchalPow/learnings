package org.example;

import java.util.ArrayList;

public class SubSetsSubSequences {
    public static void main(String[] args) {
        int[] array={3,5,7};
        ArrayList<Integer> ans=new ArrayList<>();
        printSubSequences(array,ans,0);
        sumSubsequence(array);
        System.out.println("SubSets");
        printSubsets(array,ans,0);
    }


    private static int sumSubsequence(int[] array){
        int N=array.length;
        int mainAns=0;
        for(int i=N-1; i>=0; i--){
            for(int j=i-1; j>=0; j--){
                int diff=i-j;
                int powered= (int) Math.pow(2,diff-1);
                mainAns += powered*(array[i]-array[j]);
            }
        }
        System.out.println("Main ans: "+mainAns);

        return 0;
    }
    private static void printSubsets(int[] array, ArrayList<Integer> ans, int index){
        if(index==array.length){
            System.out.println(ans);
            return;
        }
        ans.add(array[index]);
        printSubsets(array,ans,index+1);
        ans.remove(ans.size()-1);
        printSubsets(array,ans,index+1);

    }
    private static void printSubSequences(int[] array, ArrayList<Integer> ans, int index){
        if(ans.size()==array.length||index==array.length){
            System.out.println(ans);
            return;
        }
        ans.add(array[index]);
        printSubSequences(array,ans,index+1);
        ans.remove(ans.size()-1);
        printSubSequences(array,ans,index+1);
    }
}
