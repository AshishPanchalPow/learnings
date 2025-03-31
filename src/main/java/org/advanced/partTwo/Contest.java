package org.advanced.partTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class Contest {
    public static void main(String[] args) {
        Integer[] array={5,9,14,17,22,23,24,28,33,35};
        int B=5;
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(array));
        System.out.println(solve(arrayList,B));
    }
    public static int solve(ArrayList<Integer> A, int B){
        int val=1;
        int i=0;
        int missedCount=0;
        int ans=0;
        while(i<A.size()){
            if(A.get(i)==val){
                i++;
                val++;
            }
            else if(A.get(i)==val-1){
                //Duplicate
                continue;
            }
            else{
                //This is a missed natural number
                missedCount++;
                if(missedCount==B){
                    ans=val;
                    return ans;
                }
                else {
                    //i++;
                    val++;
                }
            }
        }
        ans=A.get(A.size()-1);
        while (missedCount!=B){
            ans++;
            missedCount++;
        }
        return ans;
    }
}
