package intermediate.syncissue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value value=new Value();
        Adder adder=new Adder(value);
        Subtractor subtractor=new Subtractor(value);
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Future<Void> add=executorService.submit(adder);
        Future<Void> sub=executorService.submit(subtractor);
        add.get();
        sub.get();
        System.out.println(value.val);
        executorService.shutdown();

    }
}
