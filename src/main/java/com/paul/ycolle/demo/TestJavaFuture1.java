package com.paul.ycolle.demo;

import java.util.concurrent.*;

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
        String result = null;
        try {
            result = futureTask.get(10, TimeUnit.SECONDS);//调用此方法会阻塞线程，最多阻塞10秒（如果10秒内线程还没有执行完返回的话）
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println("end");
    }
}
