package scaler.threetopics;

import java.util.*;
import java.util.Stack;

public class ScalerTest {
    public static void main(String[] args) {
        int[] asteroids={10,2,-5};
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        collsion(asteroids);
    }
    public static void collsion(int[] asteroids){
        Stack<Integer> stack=new Stack<>();
        int N=asteroids.length;
        stack.push(asteroids[0]);
        for(int i=1; i<N; i++){
            int incomingElement=asteroids[i];
            //Elements are of different sign
            if(stack.peek()*incomingElement<0){
                while (!stack.isEmpty()){
                    int top=stack.pop();
                    if(Math.abs(top)>Math.abs(incomingElement)){
                        stack.push(top);
                        break;
                    }
                    else if(Math.abs(top)<Math.abs(incomingElement)){
                        break;
                    }
                    else{
                        //Do nothing
                    }
                }
            }
            else {
                stack.push(incomingElement);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        Collections.reverse(result);
    }
}
