package org.jugistanbul.virtualthread.benchmark;

/**
 * @author Altug (altuga@gmail.com)
 *
 ***/
public class SimpleVirtualDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable printTask = () -> System.out.println("Hello Istanbul *** ");
        Runnable task = () -> System.out.println(Thread.currentThread());
        // create a new Thread

        Thread vt = Thread.ofVirtual().unstarted(task);
        vt.start();
        vt.join();

    }

}
