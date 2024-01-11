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
        Runnable printTask = () -> System.out.println("Hello Istanbul ... ***   ");
        Runnable sleepTask = () -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Thread vt = Thread.ofVirtual().name("vt").unstarted(printTask);
        // vt.start();
        // vt.join();

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_00; i++) {
                executorService.submit(printTask);
                
            }
        }

    }

}
