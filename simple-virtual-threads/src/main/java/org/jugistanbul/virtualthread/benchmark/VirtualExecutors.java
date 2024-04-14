package org.jugistanbul.virtualthread.benchmark;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualExecutors {

    public static void main(String[] args) {

        Runnable printTask = () -> System.out.println("Hello Istanbul *** ");
        Runnable sleepTask = () -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_00; i++) {
                executorService.submit(printTask);
                
            }
        }
    }

}
