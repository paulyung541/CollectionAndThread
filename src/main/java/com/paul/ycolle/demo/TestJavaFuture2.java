package com.paul.ycolle.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestJavaFuture2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("current thread : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            synchronized (TestJavaFuture2.class) {
                TestJavaFuture2.class.notifyAll();
            }
            return "123";
        };

        executorService.submit(callable);

        synchronized (TestJavaFuture2.class) {
            try {
                TestJavaFuture2.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        System.out.println("end");
    }
}
