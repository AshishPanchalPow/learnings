package leetcode;

import java.util.*;

public class PartEight {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        int[] nums={1,2,3,4,5};
        for(int num: nums) q.add(num);
        int k=3;
        System.out.println(reverseFirstK(q,k));
    }
    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        Stack<Integer> stack=new Stack<>();
        while(k>0) {
            stack.add(q.poll());
            k--;
        }
        Queue<Integer> first=new LinkedList<>();
        while(!stack.isEmpty()) first.add(stack.pop());
        while(!q.isEmpty()) first.add(q.poll());
        return first;
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int seconds=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int ticket: tickets) queue.add(ticket);
        int index=k;
        while(!queue.isEmpty()){

            if(index==0 && queue.peek()==1){
                return seconds+1;
            }
            else if(queue.peek()==1){
                queue.poll();
                seconds++;
                index--;
            }
            else if(index==0){
                queue.add(queue.remove()-1);
                seconds++;
                index=queue.size()-1;
            }
            else{
                queue.add(queue.remove()-1);
                seconds++;
                index--;
            }
        }
        return seconds;
    }
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> tempStack=new Stack<>();
        while(!stack.isEmpty()){
            int popped=stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek()<popped){
                stack.push(tempStack.pop());
            }
            tempStack.push(popped);
        }
        return tempStack;
    }
    public static int evalRPN(String[] tokens) {
        final Map<String,String> map=new HashMap<>();
        map.put("+","+");
        map.put("-","-");
        map.put("*","*");
        map.put("/","/");
        Stack<Integer> stack=new Stack<>();
        for(String tok: tokens){
            if(map.containsKey(tok)){
                Integer operandTwo=stack.pop();
                Integer operandOne=stack.pop();
                stack.push(performCal(operandOne,operandTwo,tok));
            }
            else stack.push(Integer.parseInt(tok));
        }
        return stack.pop();
    }
    public static int performCal(int op1, int op2, String operator){
        int result = 0;
        switch (operator){
            case "+":
                result=op1+op2;
                break;
            case "-":
                result=op1-op2;
                break;
            case "*":
                result=op1*op2;
                break;
            case "/":
                result=op1/op2;
                break;    
        }
        return result;
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(!stack.isEmpty() && ch.equals(')')){
                if(!stack.peek().equals('('))return  false;
                stack.pop();
            }
            else if(!stack.isEmpty() && ch.equals('}') ){
                if(!stack.peek().equals('{'))return  false;
                stack.pop();
            }
            else if(!stack.isEmpty() && ch.equals(']')){
                if(!stack.peek().equals('['))return  false;
                stack.pop();
            }
            else stack.push(ch);
        }
        return stack.isEmpty();
    }

}
