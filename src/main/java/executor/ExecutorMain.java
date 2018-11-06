package executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        System.out.println("Start");
        ex.execute(new DemoThread("A", cd1));
        ex.execute(new DemoThread("B", cd2));
        ex.execute(new DemoThread("C", cd1));
        ex.execute(new DemoThread("D", cd2));
        //countdown latchers check
        System.out.println("End");
        ex.shutdown();

    }
}
