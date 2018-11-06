package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Latcher implements Runnable{
    private String name;
    private CountDownLatch cdl;

    public Latcher(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + " " + cdl.getCount());
        cdl.countDown();
    }
}
