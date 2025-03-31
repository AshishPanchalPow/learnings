package org.advanced.partThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StacksOne {
    public static void main(String[] args) {
        //System.out.println(braces("((a+b))"));
        int[] array={4,6,10,11,7,8,3,5};
        //smallestNearLeft(array);
        Integer[] arr={8,23,22,16,22,7,7,27,35,27,32,20,5,1,35,28,20,6,16,26,48,34};
        ArrayList<Integer> arrayList= new ArrayList<>(Arrays.asList(arr));
        nextGreater(arrayList);
    }
    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        final int N=A.size();
        Integer[] ans=new Integer[N];
        Stack<Integer> stack=new Stack<>();
        for(int i=N-1;i>=0;i--){
            Integer currEl=A.get(i);
            if(!stack.isEmpty() && stack.peek()>currEl){
                ans[i]=stack.peek();

            }
            else if(!stack.isEmpty() && stack.peek()<=currEl){
                while(!stack.isEmpty() && stack.peek()<=currEl){
                    stack.pop();
                }
                ans[i]=stack.isEmpty()?-1:stack.peek();
                //stack.push(currEl);
            }
            else{
                ans[i]=-1;
            }
            stack.push(currEl);
        }
        System.out.println(Arrays.toString(ans));
        return new ArrayList<>(Arrays.asList(ans));
    }
    public static void smallestNearLeft(int[] array){
        Stack<Integer> valueStack=new Stack<>();
        Stack<Integer> idxStack=new Stack<>();
        valueStack.push(array[0]);
        idxStack.push(0);
        System.out.print(-1);
        for(int i=1; i<array.length;i++){
            int x=array[i];
            if(x>valueStack.peek()){
                System.out.print(idxStack.peek());
                valueStack.push(x);
                idxStack.push(i);

            }
            else{
                while(!valueStack.isEmpty() && valueStack.peek()>x){
                    valueStack.pop();
                    idxStack.pop();
                }
                if(idxStack.isEmpty()) System.out.print(-1);
                else System.out.print(idxStack.peek());
                valueStack.push(x);
                idxStack.push(i);
            }
        }

    }
    public static int braces(String A){
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<A.length();i++){
            Character character=A.charAt(i);
            if(character =='(' || character=='+'||character=='-'||character=='*'||character=='/'){
                stack.push(character);
            }
            else if(character==')'){
                int counter=0;
                while (!stack.isEmpty() && stack.pop() !='('){

                    counter++;
                }
                if(counter==0) return 1;
            }
        }

        return 0;
    }
}
