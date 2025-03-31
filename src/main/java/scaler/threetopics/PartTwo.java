package scaler.threetopics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class PartTwo {
    public static void main(String[] args) {
        int[] nums={3,15,6,12,4,2,10,8,5};
        int K=4;
        maxElementInWindow(nums,K);
    }
    public static void maxElementInWindow(int[] nums, int K){
        int N=nums.length;
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0; i<K;i++){
            while (!deque.isEmpty() && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        System.out.println(deque.getFirst());
        for(int i=1; i<N-K+1;i++){
            int outgoingElement=nums[i-1];
            if(outgoingElement==deque.getFirst()){
                deque.removeFirst();
            }
            int incomingElement=nums[K+i-1];
            while (!deque.isEmpty() && deque.getLast()<incomingElement){
                deque.removeLast();
            }
            deque.addLast(incomingElement);
            System.out.println(deque.getFirst());
        }
    }

    public static void nearestSmallerIndexLeft(int[] nums){
        Stack<Integer[]> stack=new Stack<>();
        stack.push(new Integer[]{nums[0],0});
        int[] ans=new int[nums.length];
        ans[0]=-1;
        for(int i=1; i<nums.length;i++){
            if(nums[i]>stack.peek()[0]){
                ans[i]=stack.peek()[1];
                stack.push(new Integer[]{nums[i],i});
            }
            else {
                while (!stack.isEmpty() && stack.peek()[0]>nums[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) ans[i]=-1;
                else ans[i]=stack.peek()[1];
                stack.push(new Integer[]{nums[i],i});
            }
        }
        System.out.println(Arrays.toString(ans));
    }

}
