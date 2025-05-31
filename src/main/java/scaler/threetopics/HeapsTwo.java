package scaler.threetopics;

import java.util.ArrayList;
import java.util.List;

public class HeapsTwo {
    public static void main(String[] args) {
        int[] nums={8,5,1,2,4,9,7};
        System.out.println( getMin(buildHeap(nums,5),nums,5));
    }
    public static int getMin(List<Integer>minHeap, int[] nums, int K){
        for(int i=K;i<nums.length;i++){
            int incoming=nums[i];
            if(minHeap.get(0)<incoming){
                minHeap.set(0,incoming);

                int k=0;
                while(true){
                    int j=k;
                    int leftIndex=2*j+1;
                    int rightIndex=2*j+2;
                    if(leftIndex<minHeap.size() && minHeap.get(leftIndex)<minHeap.get(j) && minHeap.get(leftIndex)<minHeap.get(rightIndex)){
                        //Swap minHeap.get(leftIndex) & minHeap.get(j)
                        int temp=minHeap.get(leftIndex);
                        minHeap.set(leftIndex,minHeap.get(j));
                        minHeap.set(j,temp);
                        k=leftIndex;
                    }
                    else if(rightIndex<minHeap.size() && minHeap.get(rightIndex)<minHeap.get(j) && minHeap.get(rightIndex)<minHeap.get(leftIndex)){
                        int temp=minHeap.get(rightIndex);
                        minHeap.set(rightIndex,minHeap.get(j));
                        minHeap.set(j,temp);
                        k=rightIndex;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        int answer=minHeap.get(0);

        return answer;
    }
    public static List<Integer> buildHeap(int[] nums, int K){
        List<Integer> minHeap=new ArrayList<>();
        int N=minHeap.size();
        for(int j=0;j<K;j++){
            minHeap.add(N,nums[j]);
            N+=1;
            int i=j;
            int parent=(i-1)/2;
            while(i>0){
                if(minHeap.get(j)<minHeap.get(parent)){
                    int temp=minHeap.get(parent);
                    minHeap.set(parent,minHeap.get(j));
                    i=parent;
                }
                else {
                    break;
                }
            }
        }
        return minHeap;
    }
}
