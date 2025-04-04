package scaler.threetopics;

import java.util.*;

public class PartTwo {
    public static void main(String[] args) {
        int[] nums={3,15,6,12,4,2,10,8,5};
        int K=4;
        String A="xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr";
        System.out.println(stringOnBoard(A));
    }
    public static String stringOnBoard(String A) {
        StringBuilder stringBuilder=new StringBuilder();
        Queue<Character> queue=new LinkedList<>();
        Map<Character,Integer> characterCount=new HashMap<>();
        queue.add(A.charAt(0));
        characterCount.put(A.charAt(0),1);
        stringBuilder.append(A.charAt(0));
        for(int i=1;i<A.length();i++){
            Character ch=A.charAt(i);
            characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);
            if (characterCount.get(ch) == 1) {
                queue.add(ch);
            }
            while(!queue.isEmpty() && characterCount.get(queue.peek())>1){
                queue.poll();
            }
            if(queue.isEmpty()){
                stringBuilder.append("#");
            }
            else stringBuilder.append(queue.peek());
        }
        return stringBuilder.toString();
    }
    public static String perfectNumber(int A) {
        Queue<String> primaryQueue=new LinkedList<>();
        primaryQueue.add("1");
        primaryQueue.add("2");
        int counter=0;
        String result="";
        while(counter !=A){
            String out=primaryQueue.poll();
            result=out+new StringBuilder(out).reverse().toString();
            if(counter==A){
                break;
            }
            primaryQueue.add(out+"1");
            primaryQueue.add(out+"2");
            counter++;
        }
        return result;
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
