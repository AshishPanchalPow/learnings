package org.example;

public class RecursionOne {
    public static void main(String[] args) {
        int N=5;
        //printAsc(N);
        char[] chars={'a','c','d','e','e','d','x','y'};
        //System.out.println(isPlaindrome(chars,2,5));
        //System.out.println(findAthFibonacci(5));
        //printReverse("scaleracademy");
        //System.out.println(solves(83557));
        System.out.println(solve(4,13));
    }

    private static String solve(int A, int B){
        if(A==1) return "0";
        String x=solve(A-1,B);
        return x+flip(x);
    }
    private static String flip(String x){
        String ans="";
        for(int i=0; i<x.length();i++){
            ans += x.charAt(i)=='1'?'0':'1';
        }
        return ans;
    }
    private static String revString(String x){
        char[] array=new char[x.length()];
        int start=0; int end=x.length()-1;
        while(start<end){
            char temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        return new String(array);
    }

    private static int solves(int A){
        if(A<10){
            return (A==1)?1:0;
        }
        int digit_sum=0;
        while (A>0){
            digit_sum +=A%10;
            A=A/10;
        }
        return solves(digit_sum);
    }

    private static void printReverse(String s){
        doReverse(s,0,s.length()-1);
    }
    private static void doReverse(String s, int start, int end){
        if(start>end){
            return;
        }
        System.out.print(s.charAt(end));
        doReverse(s,start+1,end-1);
        System.out.print(s.charAt(start));
    }
    private static int findAthFibonacci(int A){
        if(A<=1) return A;
        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
    private static boolean isPlaindrome(char[] characters, int s, int e){
        System.out.println("Called for: "+s+" "+e);
        if(s>e) return true;
        if(isPlaindrome(characters,s+1,e-1) && characters[s]==characters[e]) return true;
        return false;
    }
    private static void printAsc(int N){
        if(N==0) {
            return;
        }
        printAsc(N-1);
        System.out.println(N);


    }
}
