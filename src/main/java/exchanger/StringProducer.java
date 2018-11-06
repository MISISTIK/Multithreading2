package exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class StringProducer implements Runnable {
    private String s = "";
    Exchanger<String> ex;

    public StringProducer(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    s += (char) ((int) (Math.random() * 26 + 65));
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Producer: Sending " + s);
                s = ex.exchange(s);
                System.out.println("Producer: Received " + s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
