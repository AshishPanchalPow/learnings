package intermediate;

public class HelloWorldThread implements Runnable {

    @Override
    public void run() {
        System.out.println("I am coming not from main thread+ "+ Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        //HelloWorldThread task=new HelloWorldThread();
        for(int i=0; i<10;i++){
            HelloWorldThread task=new HelloWorldThread();
             Thread thread=new Thread(task);
             thread.start();
        }
    }

}

