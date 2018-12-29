package com.chris.demo.java9;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //1  execute
        for (int i = 0; i < 10; i++) {
            executor.execute(new testRunnable());
        }
        //2  submit
//        List<Future<String>> resultfuture = new ArrayList<>();
//        for(int j=0;j<10;j++) {
//            Future<String> future = executor.submit(new testCallble(j));
//            resultfuture.add(future);
//        }
//        for(Future future:resultfuture){
//            System.out.println(future.get());
//        }
        executor.shutdown();


    }
}

class testCallble implements Callable<String> {

    private int id;

    testCallble(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        System.out.println("call()方法被自动调用,干活！！！ " + Thread.currentThread().getName());
        //一个模拟耗时的操作
        for (int i = 999999; i > 0; i--) ;
        return "call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}

class testRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}