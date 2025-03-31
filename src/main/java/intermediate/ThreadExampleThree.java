package intermediate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExampleThree implements Runnable{

    @Override
    public void run() {
        System.out.println("I am coming not from main thread+ "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        ThreadExampleThree task=new ThreadExampleThree();
        for(int i=0; i<20;i++){
            executorService.execute(task);
        }
    }
}
