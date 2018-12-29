package com.chris.demo.queue;

import com.chris.demo.lock.User;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    public static void main(String arg[]) throws InterruptedException {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue<User>();

        for (int i = 0; i < 12; i++) {
            int max = 20;
            int min = 10;
            Random random = new Random();

            int n = random.nextInt(max) % (max - min + 1) + min;
            User user = new User(n, n + ":ssda");
            priorityBlockingQueue.add(user);
        }
        System.out.println("before take(), size = [" + priorityBlockingQueue.size() + "]");

        User user = (User) priorityBlockingQueue.take();
        System.out.println("take element::::" + user.getId() + "," + user.getName() + ",");
        System.out.println("after take(), size = [" + priorityBlockingQueue.size() + "]");

        for (int i = 0; i < 12; i++) {
            User u = (User) priorityBlockingQueue.take();
            String res = u != null ? "优先级是：" + u.getId() + "," + u.getName() : "empty";
            System.out.println(res);
        }

    }

}
