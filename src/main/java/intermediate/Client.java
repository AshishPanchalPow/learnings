package intermediate;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            int start=0; int end=6;
            Integer[] arr={5,3,10,-7,4,2,0};
            Sorting sorting=new Sorting(start,end,arr);
            ExecutorService ex= Executors.newFixedThreadPool(2);
        Future<ArrayList<Integer>> future=ex.submit(sorting);
        System.out.println(future.get());
        ex.shutdown();

    }
}
