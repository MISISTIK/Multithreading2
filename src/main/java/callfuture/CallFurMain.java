package callfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallFurMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(1);
        Future<String> f1 =ex.submit(new Dog());
        System.out.println(f1.get());
        ex.shutdown();
        System.out.println("END");
    }
}
