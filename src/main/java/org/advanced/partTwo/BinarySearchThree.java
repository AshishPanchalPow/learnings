package org.advanced.partTwo;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchThree {
    public static void main(String[] args) {
        int[] boards={12,34,67,90};
        int t=1;
        int x=22;
        int P=2;
        //System.out.println(minNoOfPainters(boards,t,x));
        //System.out.println(minTimeWithGivenPainters(boards,t,P));
        Integer[] arr={12,34,67,90};
        int B=2;
        ArrayList<Integer> books=new ArrayList<>(Arrays.asList(arr));
        System.out.println(books(books,B));
    }
    private static int minNoOfStudents(ArrayList<Integer>books,int B, int pages){
        int students=1;
        int availPages=pages;
        for(int i=0; i<books.size();i++){
            if(pages<books.get(i)) {
                return -1;
            }
            if(availPages>=books.get(i)){
                availPages -=books.get(i);
            }
            else{
                students++;
                availPages=pages-books.get(i);
            }
        }
        return students;
    }
    private static int books(ArrayList<Integer>books, int B){
        int ans=0;
        int N=books.size();
        if(N<B) return -1;
        if(N==B){
            // return minimum . BS will take care of it though.
        }
        int l=1;
        int r=0;
        for(Integer book: books){
            r +=book;
        }
        while (l<=r){
            int mid=(l+r)/2;
            int students=minNoOfStudents(books,B,mid);
            if(students==-1 || students>B){
                l=mid+1;
            }
            else if(students==B){
                ans=mid;
                r=mid-1;
            }
            else if(students<B){
                r=mid-1;
            }
        }
        return ans;
    }
    private static int minNoOfPainters(int[] boards,int t, int x){
        int painters=1;
        int timeAvailable=x;
        int i=0;
        while(i<=boards.length-1 && timeAvailable>=0){
            timeAvailable -=boards[i]*t;
            if(timeAvailable<0) return -1;
            i++;
            if( i<=boards.length-1 &&timeAvailable<boards[i]*t ){
                painters++;
                timeAvailable=x;
            }
        }
        return painters;
    }
    private static int minTimeWithGivenPainters(int[] boards,int t, int P){
        int minTime=Integer.MAX_VALUE;
        int r=0;int l=0;
        for(int i=0; i<boards.length;i++){
            r +=boards[i]*t;
        }
        while(l<=r){
            int mid=(l+r)/2;
            int painters= minNoOfPainters(boards,t,mid);
            if(painters==P){
                minTime=Math.min(minTime,mid);
                r=mid-1;
            }
            else if(painters>P){
                l=mid+1;
            }
            else r=mid-1;
        }
        return minTime;
    }
}
