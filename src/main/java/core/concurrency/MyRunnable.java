package core.concurrency;

import static core.concurrency.ThreadColor.ANSI_RED;

/**
 * Created by mg on 9/2/2023.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from my Runnable.");
    }
}
