package com.chris.demo.ThreadDemo;

import java.util.concurrent.Semaphore;

/**
 * 多线程执行时，只有通过acquire()获取到许可，线程才能往下运行，否则就等待其他线程释放许可
 * 像停车场一样，permits值表示停车场空位，假设permits是2，有两个空位，如果一下子来了5辆车，开始只能容两辆车进来，
 * 其他车在外面等待，当有停的车开走了了，等待的车才能开进来
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        System.out.println("Start");
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
    }

}

class SemaphoreWorker implements Runnable {
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            print("is waiting for a permit!");
            semaphore.acquire();
            print("acquired a permit!  executed!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        } finally {
            print("released a permit!");
            semaphore.release();
        }
    }

    public void print(String msg) {
        if (null == this.name) {
            this.name = Thread.currentThread().getName();
        }
        System.out.println(this.name + "  [" + msg + "]");
    }
}
