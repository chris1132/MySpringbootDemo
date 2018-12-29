package com.chris.demo.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDemo {
    public static void main(String[] args) throws Exception{
        /**
         * notEmpty��notFull ����ͬһ������������������
         * */
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        /**
         * �Ľ��������������ȣ�ͷ��β����ʹ�ò�ͬ������������ͨ�ó�����,���������Ҫ��
         **/
        LinkedBlockingDeque link  = new LinkedBlockingDeque();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();


        String MSG_HELLO = "hello";
        String MSG_BYE = "bye";

        BlockingQueue<String> msgqueue = new ArrayBlockingQueue<String>(3);

        Thread consumer = new Thread(()->{
            try {
                String msg = msgqueue.take();
                while(!MSG_BYE.equalsIgnoreCase(msg)){
                    System.out.println("Consumed :"+msg);
                    Thread.sleep(4000);
                }
                System.out.println("bye :"+msg);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread producer = new Thread(()->{
            try {
                for (int i = 1; i < 10; i++) {
                    Thread.sleep(2000);
                    String msg = MSG_HELLO+i;

                    System.out.println("Produced new item:"+msg);
                    msgqueue.put(msg);
                }
                System.out.println("item to say goodbye");
                msgqueue.put(MSG_BYE);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

    }


}
