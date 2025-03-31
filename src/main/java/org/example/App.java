package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        Integer[] input={2,1,3,4,5};
        ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(input));
        countElements(arrayList);
//        System.out.println(secondSmallest(arrayList));
        String str="abaagdacag";
//        System.out.println(countAGs(str));
        //maxProfit(arrayList);
        int[] arr={1,2,3,4,5};
        //printSubArrays(arr);
        maxSubarray(5,12,arrayList);
    }

    public static  int maxSubarray(int A, int B, ArrayList<Integer> C){
        int ans=0;
        int N=C.size();
        for(int i=0; i<N; i++) {
            for (int j = i; j < N; j++) {
                int start = i;
                int end = j;
                int sum=0;
                for(int k=start;k<=end; k++){
                    sum +=C.get(k);
                }
                if(sum<=B){
                    ans=Math.max(ans,sum);
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
    private static void printSubArrays(int[] arr){
        int N=arr.length;
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                int start=i; int end=j;
                int sum=0;
                for(int k=start; k<=end;k++){
                    sum += arr[k];
                }
                System.out.println(sum);
            }

        }
    }

    public static int maxProfit(List<Integer> A){
        int maxProfit=0;
        int min_idx=0;
        for(int i=0; i<A.size();i++){
            if(A.get(i)<A.get(min_idx)){
                min_idx=i;
            }
            if(A.get(i)>A.get(min_idx)){
                maxProfit=Math.max(maxProfit,A.get(i)-A.get(min_idx));
            }
        }
        System.out.println("Max profit "+maxProfit);

        return maxProfit;
    }
    private static int countAGs(String str){
        int N=str.length();
        int result=0;
        int countGs=0;
        for(int i=N-1;i>=0; i--){
            if(str.charAt(i)=='g'){
                countGs++;
            }
            else if(str.charAt(i)=='a'){
                result +=countGs;
            }
        }
        return result;
    }


    private static int secondSmallest(ArrayList<Integer>A){
        int max=A.get(0);
        for(Integer el: A){
            if(el>max) max=el;
        }
        int runningSecondMax=-1;
        for(Integer el: A){
            if(el==max) continue;
            if(el>runningSecondMax) runningSecondMax=el;
        }
        if(runningSecondMax==max) return -1;
        return runningSecondMax;
    }

    private static int countElements(ArrayList<Integer> A){
        int max=A.get(0);
        int freq=0;
        for(Integer el: A){
            if(el>max) {
                max = el;
                freq=1;
            }
            else if(el==max) freq++;
        }
        return A.size()-freq;
    }
}
