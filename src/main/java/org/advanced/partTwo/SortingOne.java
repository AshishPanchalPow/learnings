package org.advanced.partTwo;

import org.amadeus.oops.polymorphism.A;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingOne {
    static int x=0;
    public static void main(String[] args) {
        System.out.println("Bubble Sort");
        int[] arr={4,5,1,2,6,3};
        //bubbleSort(arr);
        System.out.println("Merge Sorted Arrays");
        Integer[] A={4,6,10,12};
        Integer[] B={3,5,7};
        ArrayList<Integer> aList=new ArrayList<>(Arrays.asList(A));
        ArrayList<Integer> bList=new ArrayList<>(Arrays.asList(B));
        //mergeSortedArray(aList,bList);
        System.out.println("Actual Merge Sort");
        int[] unsortedArray={4,5,1,2,6,3};

        MergeSort(unsortedArray,0,5);
        System.out.println(x);
    }

    private static ArrayList<Integer> MergeSort(int[] array, int s, int e){
        if(s==e){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(array[s]);
            return list;
        }
        int mid=(s+e)/2;
        ArrayList<Integer> left=MergeSort(array,s,mid);
        ArrayList<Integer> right=MergeSort(array,mid+1,e);
        return mergeSortedArray(left,right);

    }
    private static ArrayList<Integer> mergeSortedArray( ArrayList<Integer>A,  ArrayList<Integer>B){

        int N=A.size(); int M=B.size();
        ArrayList<Integer> ans=new ArrayList<>();
        int a=0; int b=0;
        while (a<N && b<M){
            if(A.get(a)<=B.get(b)){
                ans.add(A.get(a));
                a++;
            }
            else{
                x++;
                ans.add(B.get(b));
                b++;
            }
        }
        while (a < N) {
            ans.add(A.get(a));
            a++;
        }
        while (b<M){
            ans.add(B.get(b));
            b++;
        }
        System.out.println("Result after merging two sorted arrays: "+ans);
        return ans;
    }
    private static void bubbleSort(int[] arr){
        int swaps=0;
        int N=arr.length;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swaps++;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("total swaps: "+swaps);
    }
}
