package marshrutka;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

import static marshrutka.MarshrutkaMain.countDownLatch;
import static marshrutka.MarshrutkaMain.cyclicBarrier;

public class Person implements Runnable {

    private String name;

    public Person(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " start moving");
            TimeUnit.SECONDS.sleep(((int) (Math.random() * 6)) + 3);
            System.out.println(name + " reaches the marshrutka");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
