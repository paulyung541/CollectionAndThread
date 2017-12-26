package com.paul.ycolle.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService exec = Executors.newFixedThreadPool(4);
        Condition condition = lock.newCondition();
        int time = 5;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();

                    System.out.println("pre current thread ==> " + Thread.currentThread().getName() + " get the lock,  getHoldCount() = " + lock.getHoldCount());
                    condition.await(time, TimeUnit.SECONDS);
//                    Thread.sleep(time * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    System.out.println("---- post current thread ==> " + Thread.currentThread().getName() + " ,  lock : " + lock);
                    lock.unlock();
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }
//        exec.shutdown();
    }
}
