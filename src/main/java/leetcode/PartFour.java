package leetcode;

import javax.print.attribute.EnumSyntax;
import java.util.*;

public class PartFour {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int N=nums.length;
        int answer=N+1;
        int left=0; int right=0;
        int currSum=nums[left];
        while (left<=right && right<N){
            if(currSum>=target){
                answer=Math.min(answer,right-left+1);
                currSum -=nums[left];
                left++;
            }
            else{
                right++;
                if(right<N)currSum+=nums[right];
            }
        }
        return answer==N+1?0:answer;
    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result =new ArrayList<>();
        Arrays.sort(arr);
        int N=arr.length;
        int K=Integer.MAX_VALUE;
        for(int i=1;i<N; i++) K=Math.min(K,arr[i]-arr[i-1]);
        int left=0; int right=1;
        while(right<N){
            int diff=arr[right]-arr[left];
            if(left<right && diff==K){
                List<Integer> local=new ArrayList<>();
                local.add(arr[left]);
                local.add(arr[right]);
                result.add(local);
                left=right;
                right=right+1;
            }
            else if(diff>K){
                left++;
            }
            else{
                right++;
            }
        }
        return result;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int N=nums.length;
        if(k>=N) k=N-1;
        for(int i=0; i<=k;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        for(int i=1; i<N-k;i++){
            set.remove(nums[i-1]);
            if(set.contains(nums[k+i]))return true;
            set.add(nums[k+i]);
        }
        return false;
    }
    public static int longestMountain(int[] nums) {
        int answer=0;
        int N=nums.length;
        int base=0;
        while (base<N){
            int end=base;
            if(end+1<N &&nums[end]<nums[end+1]){
                while(end<N-1 && nums[end]<nums[end+1]){
                    end++;
                }
                //If really a mount
                if(end<N-1 && nums[end]>nums[end+1]){
                    while(end<N-1 && nums[end]>nums[end+1]){
                        end++;
                        answer=Math.max(answer,end-base+1);
                    }
                }
            }
            base=Math.max(end,base+1);
        }
        return answer;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer;
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0; i<nums.length-2;i++){
            int base=nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<=right && right<nums.length){
                int localsum=nums[left]+nums[right];
                if(localsum==-base && left!=right){
                    System.out.println("Answer found: "+base+","+nums[left]+","+nums[right]);
                    List<Integer> res=new ArrayList<>(3);
                    res.add(base); res.add(nums[left]); res.add(nums[right]);
                    set.add(res);
                    left++;
                }
                else if(localsum<-base){
                    left++;
                }
                else right--;

            }
        }
        answer=new ArrayList<>(set);
        return answer;
    }
}
