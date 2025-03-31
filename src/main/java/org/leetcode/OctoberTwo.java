package org.leetcode;

public class OctoberTwo {
    public static void main(String[] args) {
        //System.out.println(kthHard(4,6));
        //TOH(5,1,2,3);
        //generateBrackets(2, 0,0,"");
        int[] array={1,5,2,1,6};
        //System.out.println(recBS(array,50,0,5));
    }
    private static int recBS(int[] array, int key, int start, int end){
        if(start==end && array[start]!=key) return -1;
        int mid=(start+end)/2;
        if(array[mid]==key) return array[mid];
        if(array[mid]>key) return recBS(array,key,start,mid-1);
        else  return recBS(array,key,mid+1, end);
    }
    private static void TOH(int N, int src, int aux, int des){
        if(N==0) return;
        TOH(N-1,src,des,aux);
        System.out.println("Move Disc from: "+src+" to: "+des);
        TOH(N-1,aux, src, des);
    }
    private static void generateBrackets(int N, int open, int closed, String ans){
        if(ans.length()==2*N) {
            System.out.println(ans);
            return;
        }
        if(open<N){
            generateBrackets(N,open+1,closed,ans+"(");
        }
        if(open>closed){
            generateBrackets(N,open,closed+1,ans+")");
        }

    }
    private static int kthHard(int A, int B){
        System.out.println("A: "+A+" B: "+B);
        if(A==2){
            return B;
        }
        if(B>pow(A-2)){
            return 1-kthHard(A-1,(B-pow(A-2)));
        }
        else{
            return kthHard(A-1,B);
        }
    }
    private static int pow(int A){
       int result= (int)Math.pow(2, A);
       return result;
    }
}
