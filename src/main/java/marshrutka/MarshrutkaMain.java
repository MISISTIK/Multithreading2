package marshrutka;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MarshrutkaMain {

    static CountDownLatch countDownLatch = new CountDownLatch(1);
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Marshrutka());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Person(String.valueOf(i));
        }
        countDownLatch.countDown();

    }
}
