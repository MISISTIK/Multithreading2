package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main
{
    public static void main( String[] args ) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(10);
        long threads_num =  cdl.getCount();
        for (int i = 0; i < threads_num; i++) {
            new Latcher(String.valueOf(i),cdl);
        }
        cdl.await();
        System.out.println("END");
    }
}
