package com.chris.demo.ThreadDemo;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("args = [" + args.hashCode() + "]");
        };


        Thread thread = new Thread(runnable);

        thread.start();
        thread.join();

    }
}
