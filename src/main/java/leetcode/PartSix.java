package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartSix {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int[] vis={0,0,0};
        List<Integer> answer=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        permute(nums,vis,0,answer,result);
        System.out.println(result);
    }
    public static void permute(int[] nums,int[] vis, int index, List<Integer> answer, List<List<Integer>> result){
        if(index==nums.length){
            System.out.println(answer);
            result.add(new ArrayList<>(answer));
            return ;
        }
        for(int i=0; i<3; i++){
            if(vis[i]==0){
                answer.add(nums[i]);
                vis[i]=1;
                permute(nums,vis,index+1,answer,result);
                answer.remove(index);
                vis[i]=0;
            }
        }
    }
}
