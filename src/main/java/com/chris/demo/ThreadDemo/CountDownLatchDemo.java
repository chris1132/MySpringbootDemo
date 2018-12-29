package com.chris.demo.ThreadDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * ���߳���ͨ��await
 */
public class CountDownLatchDemo {

    public static void main(String args[]) throws Exception {
        int MaxCountDownLatchNumber = 7;

        final CountDownLatch countDownLatch = new CountDownLatch(7);
        for (int i = 1; i <= MaxCountDownLatchNumber; i++) {
            System.out.println("��ʼ�ռ�:" + i);
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("���ռ�:" + index);
                    countDownLatch.countDown();
                    System.out.println("�ɹ�----------------:" + index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await(10000, TimeUnit.MILLISECONDS);

        System.out.println("����ռ�");

    }

}
