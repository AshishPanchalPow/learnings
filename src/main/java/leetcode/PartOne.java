package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PartOne {
    public static void main(String[] args) {
        //int[] nums={4,3,2,7,8,2,3,1};
        //int[] nums={4,3,2,7,8,2,3,1};
        int[] nums={1,1};
        System.out.println( findDisappearedNumbers(nums));
    }
    public static int missingNumber(int[] nums){
        Arrays.sort(nums);
        int expected=0;
        for(int num: nums){
            if(num==expected){
                expected++;
                continue;
            }
            else return expected;
        }
        return expected;
    }
//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> ans=new ArrayList<>();
//        Arrays.sort(nums);
//        int N=nums.length;
//        int i=0;
//        int expected=1;
//        while(i<=N-1){
//            if(nums[i]==expected){
//                while(i+1<N && nums[i+1]==nums[i]){
//                    i++;
//                }
//            }
//        }
//        return ans;
//    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<String> set=new HashSet<>(nums.length);
        set.add(Arrays.toString(nums));
        return !(set.containsAll(Arrays.asList()));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(nums);
        int expected=1;
        int i=0;
        int N=nums.length;
        while (i<N){
            if(nums[i] !=expected){
                result.add(expected);
            }
            else{
                while(i<N-1 && nums[i+1]==expected){
                    i++;
                }
            }
            expected++;
            i++;
        }
        return result;

    }
}
