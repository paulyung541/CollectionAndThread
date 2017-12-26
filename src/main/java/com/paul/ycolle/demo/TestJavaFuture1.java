package com.paul.ycolle.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestJavaFuture1 {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            System.out.println("current thread : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            synchronized (TestJavaFuture1.class) {
                TestJavaFuture1.class.notifyAll();
            }
            return "123";
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        synchronized (TestJavaFuture1.class) {
            try {
                TestJavaFuture1.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }
}
