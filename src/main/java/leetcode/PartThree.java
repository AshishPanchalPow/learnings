package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PartThree {
    public static void main(String[] args) {
        int[] nums ={-5,-2,-1};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int N=nums.length;
        int[] result=new int[N];
        if(nums[0]>=0){
            for(int i=0; i<N;i++){
                result[i]=nums[i]*nums[i];
            }
            return result;
        }
        //Else, find the index where it just goes greater than equal to 0.
        int right=-1;
        for(int i=0; i<N;i++){
            if(nums[i]>=0){
                right=i;
                break;
            }
        }
        if(right==-1){
            //special case of reverse and square. Will code it in a sec
            for(int i=0; i<N;i++){
                result[i]=nums[N-1-i]*nums[N-1-i];
            }
            return result;
        }
        int left=right-1;
        int counter=0;
        while(left>=0 && right<N){
            if(Math.abs(nums[left])<nums[right]){
                result[counter]=nums[left]*nums[left];
                counter++;
                left--;
            }
            else if(Math.abs(nums[left])==nums[right]){
                result[counter]=nums[left]*nums[left];
                counter++;
                left--;
                result[counter]=nums[right]*nums[right];
                counter++;
                right++;
            }
            else{
                result[counter]=nums[right]*nums[right];
                counter++;
                right++;
            }
        }
        while(left>=0){
            result[counter]=nums[left]*nums[left];
            counter++;
            left--;
        }
        while(right<N){
            result[counter]=nums[right]*nums[right];
            counter++;
            right++;
        }
        return result;
    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int buyAmount=prices[0];
        for(int i=1; i<prices.length;i++){
            int localProfit=prices[i]-buyAmount;
            if(localProfit>maxProfit) maxProfit=localProfit;
            if(prices[i]<buyAmount) buyAmount=prices[i];
        }
        return maxProfit;
    }
}
