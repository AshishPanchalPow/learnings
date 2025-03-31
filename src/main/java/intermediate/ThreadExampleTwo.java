package intermediate;

import java.util.concurrent.*;

public class ThreadExampleTwo implements Callable {
    int counter;
    ThreadExampleTwo(int counter){
        this.counter=counter;
    }
    @Override
    public Integer call() {
        System.out.println("Called from: "+Thread.currentThread().getName());
        return this.counter+1;
    }

    public static void main(String[] args) {
        ThreadExampleTwo task=new ThreadExampleTwo(10);
        ExecutorService service= Executors.newFixedThreadPool(4);
        Future<Integer> futureResult=service.submit(task);
        try{
            Integer result=futureResult.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();

    }
}
