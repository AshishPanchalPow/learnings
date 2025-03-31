package org.advanced.partTwo;

import org.amadeus.oops.polymorphism.A;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        printParenthesis(2,"",0,0);
        TOH(3,'A','B','C');
        ArrayList<Integer> ans= new ArrayList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        print(2,4,1,ans,res);
        System.out.println(res);
    }

    private static void print(int K, int N, int index, ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> res){
        if(K==0) {
            res.add(ans);
            return;
        }
        if(index>N){
            return;
        }

        print(K,N,index+1,ans,res);
        ans.add(index);
        print(K-1,N,index+1,ans,res);

    }
    private static void TOH(int N, char A, char B, char C){
        if(N==0){
            return;
        }
        TOH(N-1, A,C,B);
        System.out.println("Move disc no. "+N+" from : "+A+" to: "+C);
        TOH(N-1,B,A,C);

    }
    private static void printParenthesis(int N, String curr, int op, int cl){
        //System.out.println("Opening: "+ op+ " Closing: "+cl);
        if(curr.length()==2*N){
            System.out.println(curr);
            return ;
        }
        if(op<N)printParenthesis(N,curr+"(",op+1, cl);
        if(op>cl)printParenthesis(N,curr+")",op,cl+1);

    }
}
