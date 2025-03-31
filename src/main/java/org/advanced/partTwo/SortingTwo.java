package org.advanced.partTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingTwo {
    public static void main(String[] args) {
        int[] array={7,3,2,5,1,6,4,-1,10};
        System.out.println("Pivot Question");
        //pivot(array,0,array.length-1);
        quickSort(array,0,array.length-1);
        int[] arr={51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62};
        minIncrements(arr);
        int[] ar={51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62};
        minIncrementOptimal(ar);
        Integer[] arrr={1,2,0,3,5,4};
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(arrr));
        maxChunks(A);
        Integer[] arrrr={1,2,6,3,5,4,0};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(arrrr));
        wave(arrayList);
    }
    public static  ArrayList<Integer> wave(ArrayList<Integer> A){

        Collections.sort(A);
        for(int i=0; i<A.size();i+=2){
            //swap A.get(i), A.get(i+1)
            if(i==A.size()-1){
                continue;
            }
            int temp=A.get(i);
            A.set(i,A.get(i+1));
            A.set(i+1,temp);
        }
        return A;
    }
    private static int maxChunks(ArrayList<Integer>A){
        int ans=0;
        int max=A.get(0);
        for(int i=1; i<A.size();i++){
            if(A.get(i)>max) {
                max = A.get(i);
            }
            if(max==i){
                ans++;
            }
        }
        //System.out.println(ans);
        return ans;
    }
    private static int minIncrementOptimal(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int max=arr[0];
        int count=0;
        for(int i=1; i<arr.length;i++){
            int curr=arr[i];
            if(curr>max){
                max=curr;
            }
            else if(curr==max){
                count++;
                max=curr+1;
            }
            else {
                count += max-curr+1;
                max=max+1;
            }
        }
        System.out.println(count);
        return count;
    }
    private static int minIncrements(int[] arr){
        int count=0;
        for(int i=1; i<arr.length;i++){
            int curr=arr[i];
            //Check if element present on left hand side
            boolean isPresent=checkLHS(arr, 0, i-1, curr);
            //increment curr till element is unique on the left hand side
            while (isPresent){
                count++;
                arr[i]++;
                curr=arr[i];
                isPresent=checkLHS(arr,0,i-1,curr);
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
        return count;
    }
    private static boolean checkLHS(int[]arr, int start, int end, int curr){
        for (int i=start; i<=end; i++){
            if(arr[i]==curr) return true;
        }
        return false;
    }
    private static void quickSort(int[] array, int start, int end){
        if(start>end) return;
        int piv=pivot(array,start, end);
        quickSort(array,start,piv-1);
        quickSort(array,piv+1,end);
    }

    private static int pivot(int[] arr, int lo, int hi){
        int pivIdx=hi;
        int i=lo; int j=lo;
        while (j<hi){
            if(arr[j]<arr[pivIdx]){
                //swap arr[j] with arr[i] increment i;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
            j++;
        }
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
        System.out.println(Arrays.toString(arr));
        return i;
    }
}
