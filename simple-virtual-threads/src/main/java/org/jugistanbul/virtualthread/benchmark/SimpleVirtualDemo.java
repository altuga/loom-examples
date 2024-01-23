package org.jugistanbul.virtualthread.benchmark;

import org.jugistanbul.util.ThreadType;
import org.jugistanbul.util.ThreadUtil;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

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
