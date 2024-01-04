package org.jugistanbul.virtualthread.benchmark;

import org.jugistanbul.util.ThreadType;
import org.jugistanbul.util.ThreadUtil;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Altug (altuga@gmail.com)
 *
 ***/
public class SimpleVirtualDemo {

    public static void main(String[] args) throws InterruptedException{
         Runnable printTask = ()-> System.out.println("Hello Istanbul ... ***   ");
         Runnable sleepTask = () -> System.out.println("...slepping ..." );   
        
         Thread vt = Thread.ofVirtual().name("vt").unstarted(printTask);
         vt.start();
         vt.join();
    }

    
}
