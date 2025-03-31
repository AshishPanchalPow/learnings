package org.advanced.partTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        Integer[] array={1,1000000000,1000000000};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(array));
        int B=38;
        //System.out.println(searchInsert(arrayList,B));
        //System.out.println(solve(arrayList));
        Integer[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for(Integer[] e: arr){
            A.add(new ArrayList<Integer>(Arrays.asList(e)));
        }
        System.out.println(searchMatrix(A,B));

    }
    private static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B){
        int N=A.size();
        int M=A.get(0).size();
        int l=0; int r=(N*M)-1;
        while (l<=r){
            int mid=(l+r)/2;
            int rowIdx=mid/M;
            int colIdx=mid%M;
            if(A.get(rowIdx).get(colIdx)==B){
                return 1;
            }
            else if(A.get(rowIdx).get(colIdx)>B){
                r=mid-1;
            }
            else l=mid+1;
        }
        return 0;
    }
    private static int solve(ArrayList<Integer>A){
        int N=A.size();
        if(N==1) return A.get(0);
        if(A.get(0)>A.get(1)) return A.get(0);
        if(A.get(N-1)>A.get(N-2)) return A.get(N-1);
        int l=1; int r=N-2;
        while (l<=r){
            int mid=(l+r)/2;
            if(A.get(mid)>A.get(mid-1) && A.get(mid)>A.get(mid+1)){
                return A.get(mid);
            }
            else if(A.get(mid)>A.get(mid-1) && A.get(mid)<A.get(mid+1)){
                l=mid+1;
            }
            else r=mid-1;
        }
        return -1;
    }
    private static int searchInsert(ArrayList<Integer> A, int B) {
        int l=0;
        int r=A.size()-1;
        int ans=A.size();
        while (l<=r){
            int mid=(l+r)/2;
            if(A.get(mid)==B){
                return mid;
            }
            else if(A.get(mid)>B){
                ans=mid;
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return ans;
    }

}
