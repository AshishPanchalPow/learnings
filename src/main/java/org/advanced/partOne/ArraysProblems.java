package org.advanced.partOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysProblems {
    public static void main(String[] args) {
        String A="100110001";
        flip(A);
        int[] nums={-5,1,2,-9,2,-7,4,18,3};
        missingNaturalNumber(nums);
        int[] numbers={5,4,3,2,1};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("******* Next Permutation *********");
        Integer[] sequence={5,4,3,2,1};
        ArrayList<Integer> AL=new ArrayList<>(Arrays.asList(sequence));
        nextPermutation(AL);
        System.out.println("******* Max 1s *********");
        Integer[][] binaries={{0,1,1},{0,0,1},{0,1,1}};
    }

    private static  ArrayList<Integer> nextPermutation(ArrayList<Integer> A){
        int N=A.size();
        if(N<=1) return A;
        int i=N-2;
        while(i>=0 && A.get(i)>=A.get(i+1)){
            i--;
        }
        if(i==-1) {
            Collections.sort(A);
            return A;
        }
        int j=N-1;
        while(j>=0){
            if(A.get(j)>A.get(i)){

                break;
            }
            j--;
        }
        int temp=A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);

        int start=i+1;
        int end=N-1;
        while (start<end){
            int tempo=A.get(start);
            A.set(start,A.get(end));
            A.set(end,tempo);
            start++;
            end--;
        }
        System.out.println(A);
        return A;
    }

    private static int missingNaturalNumber(int[] nums){
        int i=0;
        final int N=nums.length;
        while(i<N){
            if((nums[i]<0) ||(nums[i]>N)){
                i++;
            }
            else{
                int correct_index=nums[i]-1;
                if(nums[correct_index] ==nums[i]){
                    i++;
                }
                else {
                    int temp=nums[correct_index];
                    nums[correct_index]=nums[i];
                    nums[i]=temp;
                }
            }

        }
        System.out.println(Arrays.toString(nums));







        return 0;
    }
    private static ArrayList<Integer> flip(String A){
        int l=-1; int r=-1;
        int N=A.length();
        int[] array=new int[N];
        for(int i=0; i<N; i++){
            array[i]=A.charAt(i)=='1'?1:0;
        }
        for(int i=0; i<array.length;i++){
            if(array[i]==0){
                l=i;
                r=i;
                break;
            }
        }
        int maxSum=0;
        int curr=0;
        for(int i=0; i<N; i++){
            if(array[i]==1){
                curr--;
            }else{
                curr++;
            }
            if(curr>maxSum) maxSum=curr;
            if (curr<0) {
                l=i+1;
                curr = 0;
            }
        }
        System.out.println("Max possible sume is: "+maxSum);
        System.out.println(l+"  "+r);
        return new ArrayList<>();
    }
    private static int maxSubArray(final List<Integer> A){
        int ans=Integer.MIN_VALUE;
        int currSum=0;
        for(int el: A){
            currSum +=el;
            ans=Math.max(ans,currSum);
            if(currSum<0) currSum=0;
        }

        return ans;
    }
}
