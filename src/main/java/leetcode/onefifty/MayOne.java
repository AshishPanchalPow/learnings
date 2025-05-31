package leetcode.onefifty;

import java.util.Arrays;
import java.util.Map;

public class MayOne {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int N=prices.length;
        int i=1;
        int maxProfit=0;
        int leftIndex=0;
        int rightIndex=0;
        while (i<N){
            if(prices[i]>prices[i-1]){
                rightIndex++;
            }
            else{
                maxProfit +=prices[rightIndex]-prices[leftIndex];
                leftIndex=i;
                rightIndex=i;
            }
            i++;
        }
        maxProfit +=prices[rightIndex]-prices[leftIndex];
        return maxProfit;
    }
    public static int _maxProfit(int[] prices){
        int maxProfit=0;
        int buyingPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            maxProfit= Math.max(maxProfit,prices[i]-buyingPrice);
            if(prices[i]<buyingPrice) buyingPrice=prices[i];
        }
        return maxProfit;
    }
    public static void rotate(int[] nums, int k) {
        int N=nums.length;
        k=k%N;
        int i=k-1;
        int j=N-k;
        while (i>=0 && j<N){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i--;
            j++;
        }
        System.out.println(Arrays.toString(nums));
        swap(nums,0,k-1);
        System.out.println(Arrays.toString(nums));
        swap(nums, k,N-1);

        System.out.println(Arrays.toString(nums));
    }
    private static void swap(int[] nums, int left, int right){
        int firstHalfLeft=left;
        int firstHalfRight=right;
        while (firstHalfLeft<firstHalfRight){
            int temp=nums[firstHalfLeft];
            nums[firstHalfLeft]=nums[firstHalfRight];
            nums[firstHalfRight]=temp;
            firstHalfRight--;
            firstHalfLeft++;
        }
    }

    public static int majorityElement(int[] nums) {
        int majorityEl=nums[0];
        int frequency=1;
        for(int i=1; i<nums.length;i++){
            if(frequency==0){
                majorityEl=nums[i];
                frequency++;
            }
            else if(nums[i]==majorityEl){
                frequency++;
            }
            else frequency--;
        }
        return majorityEl;
    }
    public static int _remove(int[] nums){
       int N=nums.length;
       if(N<3) return N;
       int i=1; int j=1; int count=1;
       while (i<N){
           if(nums[i]==nums[i-1]){
               count++;
               if(count>2){
                   i++;
                   continue;
               }
           }
           else{
               count=1;
           }
           nums[j]=nums[i];
           i++;
           j++;

       }
       //System.out.println(Arrays.toString(nums));
       return j;
    }
    public static int removeDuplicatesTwo(int[] nums) {
        int result=0;
        int N=nums.length;
        if(N<3) return N;
        int insertIdx=2;
        int local=1;
        for(int i=2; i<N;i++){
            if(local==2){
                insertIdx+=2;
            }
            if(nums[i]!=nums[insertIdx]){
                nums[insertIdx]=nums[i];
                insertIdx++;
            }
            else{
                local++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return result;

    }
    public static int removeDuplicates(int[] nums) {
        int N=nums.length;
        if(N<2) return N;
        int insertIdx=1;
        for(int i=1;i<N;i++){
            if(nums[i] !=nums[i-1]){
                nums[insertIdx]=nums[i];
                insertIdx++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return insertIdx;
    }
    public static int removeElement(int[] nums, int val) {
        int front=0;
        int back=nums.length-1;
        int k=back;
        while (front<back){
            if(nums[front]==val){
                while(back>0 && nums[back] ==val){
                    back--;
                }

                int temp=nums[front];
                nums[front]=nums[back];
                nums[back]=temp;
                front++;
                back--;
            }
            else front++;
        }
        while (k>=0 &&nums[k]==val){
            k--;
        }
        System.out.println(Arrays.toString(nums));
        return k+1;

    }
}
