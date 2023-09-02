package core.concurrency;

import static core.concurrency.ThreadColor.ANSI_BLUE;

/**
 * Created by mg on 9/2/2023.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from MyThread.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {

        }
        System.out.println(ANSI_BLUE + "1 second has passed and I am awake.");
    }
}
