package intermediate;

import org.amadeus.oops.polymorphism.A;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorting implements Callable {
    ArrayList<Integer> list;
    Integer[] arr;
    int start;
    int end;
    Sorting(int start, int end, Integer[] arr){
        this.start=start;
        this.end=end;
        this.arr=arr;
    }
    public  ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        int i=0; int N=left.size();
        int j=0; int M=right.size();
        ArrayList<Integer> answer=new ArrayList<>();
        while(i<N && j<M){
            if(left.get(i)<right.get(j)){
                answer.add(left.get(i));
                i++;
            }
            else {
                answer.add(right.get(j));
                j++;
            }
        }
        if(i<N){
            while (i<N){
                answer.add(left.get(i));
                i++;
            }
        }
        if(j<M){
            while (j<M){
                answer.add(right.get(j));
                j++;
            }
        }
        return answer;
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        if(start==end){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(arr[start]);
            return list;
        }
        int mid=(start+end)/2;
        Sorting leftSorting=new Sorting(start,mid,arr);
        Sorting rightSorting=new Sorting(mid+1,end,arr);
        ExecutorService ex= Executors.newFixedThreadPool(10);
        Future<ArrayList<Integer>> leftSortedFuture=ex.submit(leftSorting);
        Future<ArrayList<Integer>> rightSortedFuture=ex.submit(rightSorting);
        ArrayList<Integer> leftSorted=leftSortedFuture.get();
        ArrayList<Integer> rightSorted=rightSortedFuture.get();
        ex.shutdown();
        return merge(leftSorted,rightSorted);
    }
}
