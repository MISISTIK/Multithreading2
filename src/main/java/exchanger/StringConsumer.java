package exchanger;

import java.util.concurrent.Exchanger;

public class StringConsumer implements Runnable {

    String s = "";
    Exchanger<String> ex;

    public StringConsumer(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                s = ex.exchange("");
                System.out.println("Consumer: Received " + s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
