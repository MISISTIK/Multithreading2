package callfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Dog implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Thread started");
        TimeUnit.SECONDS.sleep(4);
        return "Some string from thread";
    }
}
