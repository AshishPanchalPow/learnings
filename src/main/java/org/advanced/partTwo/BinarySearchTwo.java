package org.advanced.partTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTwo {
    public static void main(String[] args) {
        System.out.println("Yo");
        Integer[] A={0,23};
        ArrayList<Integer> a=new ArrayList<>(Arrays.asList(A));
        Integer[] B={};
        ArrayList<Integer> b=new ArrayList<>(Arrays.asList(B));
        System.out.println(findMedianSortedArrays(a,b));
    }
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b){
        int N=a.size();
        int M=b.size();
        if(N==0){
            if(M%2==0){
                return (double) (b.get((M-1)/2)+b.get((M-1)/2+1))/2;
            }
            else{
                return (double)b.get((M-1)/2);
            }
        }
        if(M==0){
            if(N%2==0){
              return  (double) (a.get((N-1)/2)+a.get((N-1)/2+1))/2;
            }
            else{
                return (double)a.get((N-1)/2);
            }
        }
        int l=0; int r=Math.min((N+M)/2, N);
        while (l<=r){
            int pickA=(l+r)/2;
            int pickB=(N+M+1)/2 -pickA;
            int l1=pickA==0?Integer.MIN_VALUE:a.get(pickA-1);
            int l2=pickB==0?Integer.MIN_VALUE:b.get(pickB-1);
            int r1=pickA==N?Integer.MAX_VALUE:a.get(pickA);
            int r2=pickB==M?Integer.MAX_VALUE:b.get(pickB);
            if(l1<=r2 && l2<=r1){
                System.out.println("Perfect Set");
                if((N+M)%2==0){
                    return (double) ((Math.max(l1,l2) + Math.min(r1,r2))/2);
                }
                else {
                    return (double) Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                //System.out.println("Going left");
                r=pickA-1;
            }
            else {
                //System.out.println("Going right");
                l=pickA+1;
            }
        }

        return 0.0;
    }
}
