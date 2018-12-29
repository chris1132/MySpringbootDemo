package com.chris.demo.ThreadDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static int MaxCountDownLatchNumber = 7;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MaxCountDownLatchNumber, new Thread(() -> {
        System.out.println("����ռ�");
    }));

    public static void main(String args[]) {

        for (int i = 1; i <= MaxCountDownLatchNumber; i++) {
            System.out.println("��ʼ�ռ�:" + i);
            int index = i;
            new Thread(() -> {

                System.out.println("���ռ�:" + index);
                try {
                    cyclicBarrier.await();
                    System.out.println("�ɹ��ռ�:" + index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
        System.out.println("222");
    }
}
