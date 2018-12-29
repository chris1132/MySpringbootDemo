package com.chris.demo.lock;


import java.util.concurrent.locks.*;

public class ReentrantLockDemo {

    public static void main(String[] args) throws Exception {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        reentrantLockDemo.test3();
//        reentrantLockDemo.test4();
//        reentrantLockDemo.test5();
    }

    /**
     * ����lock��t1�̵߳ȴ����߳��ͷ���,��ʹ���̵߳���t1.interrupt()���߳�t1���صȴ���ȡ��
     **/
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 start.");
                lock.lock();
                System.out.println("t1 get lock.");
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println("main  .");
        t1.interrupt();
        System.out.println("main 2 .");
        Thread.sleep(1000000);
    }

    /**
     * ����lockInterruptibly��t1�̵߳ȴ����߳��ͷ����������߳�interrupt�ж��߳�t1��t1�׳�InterruptedException
     **/
    public void test4() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t1 start.");
                    lock.lockInterruptibly();
                    System.out.println("t1 get lock.");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        });
        t1.start();
        Thread.sleep(2000);
        System.out.println("t1  isInterrupted ." + t1.isInterrupted());
        t1.interrupt();
        System.out.println("main  2.");
        Thread.sleep(1000000);
    }

    /**
     * ����lockInterruptiblyʱ�߳����Ѿ���interrupt״̬ʱ��ֱ�ӵ�InterruptedException
     */
    public void test5() throws Exception {
        final Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t1 start.");
                    Thread.sleep(2000);
                    System.out.println("Thread status." + Thread.interrupted());
                    lock.lockInterruptibly();
                    System.out.println("t1 after.");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        });
        t1.start();
        System.out.println("main .");
        t1.interrupt();
        System.out.println("Thread isInterrupted." + t1.isInterrupted());
        System.out.println("main 2.");
        Thread.sleep(10000000);
    }
}
