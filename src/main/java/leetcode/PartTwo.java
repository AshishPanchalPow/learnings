package leetcode;

import java.util.*;

public class PartTwo {
    public static void main(String[] args) {
        int[][] points={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(points));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int N=matrix.length;
        int M=matrix[0].length;
        int top=0;int left=0;
        int bottom=N-1; int right=M-1;

        while (top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                //System.out.println(top +","+i);
                result.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom;i++){
                //System.out.println(i+","+right);
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right; i>=left;i--){
                    //System.out.println(bottom+","+i);
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    //System.out.println(i+","+left);
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    private static void printIndexes(int n, int m){
        int i=0; int j=0; int increment;

        for(int k=0; k<2; k++){
            increment=k;
            int x=i+increment; int y=j+increment;
            while(y !=m-1-increment){
                System.out.println(x +","+y);
                y++;
            }
            while(x !=n-1-increment){
                System.out.println(x +","+y);
                x++;
            }
            while(y !=increment){
                System.out.println(x +","+y);
                y--;
            }
            while (x !=increment){
                System.out.println(x +","+y);
                x--;
            }
        }

    }
    public static int minTimeToVisitAllPoints(int[][] points) {
        int mincount=0;
        int N=points.length;
        for(int i=0; i<N-1; i++){
            int[] startPoint=points[i];
            int[] endPoint=points[i+1];
            int diagonalSteps=Math.max(Math.abs(startPoint[0]-endPoint[0]),Math.abs(startPoint[1]-endPoint[1]));
            mincount+=diagonalSteps;
        }
        return mincount;
    }
    private static int distBetweenTwoPoints(int[][] points, int index){
        int[] startPoint=points[index];
        int[] endPoint=points[index+1];
        int diagonalSteps=Math.max(Math.abs(startPoint[0]-endPoint[0]),Math.abs(startPoint[1]-endPoint[1]));
        return diagonalSteps;

    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] original=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        int[] answer=new int[nums.length];
        for(int i=0; i<original.length;i++){
            answer[i]=map.get(original[i]);
        }
        return answer;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer> freqList=map.get(nums[i]);
                freqList.add(i);
                map.put(nums[i],freqList);
            }
            else{
                ArrayList<Integer> single=new ArrayList<>();
                single.add(i);
                map.put(nums[i],single);
            }
        }
        System.out.println(map);
        for(int i=0; i<nums.length;i++){
            int needed=target-nums[i];
            if(map.containsKey(needed)){
                if(needed==nums[i] && map.get(needed).size()>1){
                    ans[0]=map.get(needed).get(0);
                    ans[1]=map.get(needed).get(1);
                }
                if(needed !=nums[i]) {
                    ans[0]=i;
                    ans[1]=map.get(needed).get(0);
                }
            }
        }
        return ans;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0; i<nums.length;i++){
            if(!set.contains(i+1)){
                result.add(i+1);
            }
        }

        return result;
    }
}
