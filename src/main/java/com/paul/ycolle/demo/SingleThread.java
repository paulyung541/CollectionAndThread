package com.paul.ycolle.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {
    private static int a = 0;

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " - start");
            int i = 0;
            while (i < 3) {
                a++;
                try {
                    Thread.sleep(1000);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a = " + a);
            }
            System.out.println(Thread.currentThread().getName() + " - end");
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; ++i) {
            executorService.submit(task);
        }

        executorService.shutdownNow();//注意，正在执行的任务执行完之后，队列里的任务将不会再执行
    }
}
