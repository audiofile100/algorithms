package core.concurrency;

import static core.concurrency.ThreadColor.ANSI_GREEN;
import static core.concurrency.ThreadColor.ANSI_PURPLE;

/**
 * Created by mg on 9/2/2023.
 */
public class Basics {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread myThread = new MyThread();
        myThread.start();

        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class Thread.")).start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
    }
}
