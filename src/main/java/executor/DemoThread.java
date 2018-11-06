package executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DemoThread implements Runnable {

    String name;
    CountDownLatch cd;

    public DemoThread(String name, CountDownLatch cd) {
        this.name = name;
        this.cd = cd;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(name + " : " + i);
                TimeUnit.SECONDS.sleep(1);
                cd.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
