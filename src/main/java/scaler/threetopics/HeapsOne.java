package scaler.threetopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
For heaps, we could visualise as Balanced Binary Trees i.e. All rows have two kids apart from the last
For an index i, the left child is at 2*i+1, right is at 2*i+2;
Same way for parent.
Min Heap - the root child is less than or equal to children
 */
public class HeapsOne {
    public static void main(String[] args) {
        Integer[] nums={2,4,5,11,6,7,8,20,12};
        List<Integer> underlyingArr= new ArrayList<>();
        for(Integer num: nums) insertInHeap(underlyingArr,num);
        System.out.println(underlyingArr);
        getMin(underlyingArr);
        System.out.println(underlyingArr);
    }
    private static int getMin(List<Integer> underlyingArr){
        int ans=underlyingArr.get(0);
        underlyingArr.set(0,underlyingArr.get(underlyingArr.size()-1));
        underlyingArr.remove(underlyingArr.size()-1);
        int N=underlyingArr.size();
        int i=0;
        while (true){
            int leftIdx=2*i+1;
            int rightIdx=2*i+2;
            int leftVal=(leftIdx>=N)?Integer.MAX_VALUE:underlyingArr.get(leftIdx);
            int rightVal=(rightIdx>=N)?Integer.MAX_VALUE:underlyingArr.get(rightIdx);
            if(leftVal<rightVal && leftVal<=underlyingArr.get(i)){
                int temp=underlyingArr.get(i);
                underlyingArr.set(i,leftVal);
                underlyingArr.set(leftIdx,temp);
                i=leftIdx;
            }
            else if(rightVal<leftVal && rightVal<=underlyingArr.get(i)){
                int temp=underlyingArr.get(i);
                underlyingArr.set(i,rightVal);
                underlyingArr.set(rightIdx,temp);
                i=rightIdx;
            }
            else{
                break;
            }
        }
        return ans;
    }
    private static void insertInHeap(List<Integer> underlyingArr, int num){
        int N=underlyingArr.size();
        int i=N;
        underlyingArr.add(num);
        while(i>1){
            int parent=(i-1)/2;
            if(underlyingArr.get(parent)>underlyingArr.get(i)){
                // Swap the child & parent
                int temp=underlyingArr.get(parent);
                underlyingArr.set(parent,underlyingArr.get(i));
                underlyingArr.set(i,temp);
                i=parent;
            }
            else {
                break;
            }
        }
    }

}
