package com.chris.demo.ThreadDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static int MaxCountDownLatchNumber = 7;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MaxCountDownLatchNumber, new Thread(() -> {
        System.out.println("完成收集");
    }));

    public static void main(String args[]) {

        for (int i = 1; i <= MaxCountDownLatchNumber; i++) {
            System.out.println("开始收集:" + i);
            int index = i;
            new Thread(() -> {

                System.out.println("已收集:" + index);
                try {
                    cyclicBarrier.await();
                    System.out.println("成功收集:" + index);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
        System.out.println("222");
    }
}
