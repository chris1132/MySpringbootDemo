package com.chris.demo.ThreadDemo;

import java.util.concurrent.Semaphore;

/**
 * ���߳�ִ��ʱ��ֻ��ͨ��acquire()��ȡ����ɣ��̲߳����������У�����͵ȴ������߳��ͷ����
 * ��ͣ����һ����permitsֵ��ʾͣ������λ������permits��2����������λ�����һ��������5��������ʼֻ����������������
 * ������������ȴ�������ͣ�ĳ��������ˣ��ȴ��ĳ����ܿ�����
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
