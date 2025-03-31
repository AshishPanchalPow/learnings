package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        System.out.println("Yo");
        Integer[] input={4,6,5,3,4,5,6,4,4,4};
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(input));
        //goodSubArrays(arrayList,242);
        System.out.println(subArrayWithSum(arrayList,2,10));
        majorityElement(arrayList);
    }

    private static int majorityElement(final List<Integer>A){
        int majEl=A.get(0);
        int freq=1;
        int N=A.size();
        for(int i=1; i<N; i++){
            if(freq==0){
                majEl=A.get(i);
                freq++;
            }
            else if(A.get(i)==majEl) freq++;
            else {
                freq--;
            }
        }
        System.out.println("Possible Maj Element: "+majEl+" with frequency as: "+freq);
        return -1;
    }
    private static int subArrayWithSum(ArrayList<Integer> A, int B, int C){
        int sum=0;
        int N=A.size();
        for(int i=0; i<B; i++){
            sum +=A.get(i);
        }
        if(sum==C) return 1;
        int s=1; int end=B;
        while (end<N){
            sum -=A.get(s-1);
            sum +=A.get(end);
            if(sum==C) return 1;
            s++; end++;
        }
        return 0;
    }
    public static int goodSubArrays(ArrayList<Integer> A, int B){
        int N=A.size();
        for(int i=1; i<N; i++){
            A.set(i,A.get(i)+A.get(i-1));
        }
        System.out.println(A);
        int ans=0;
        for(int i=0; i<N;i++){
            for(int j=i; j<N; j++){
                int sum=0;
                if(i==0) sum=A.get(j);
                else{
                   sum=A.get(j)-A.get(i-1);
                }
                if(j==i){
                    if(sum>B) ans++;
                }
                else{
                    if(sum<B &&(j+1-i)%2==0) ans++;
                    if(sum>B &&(j+1-i)%2==1) ans++;
                }
                System.out.println(sum);
            }
        }
        System.out.println("Ans: "+ans);
        return ans;
    }
}
