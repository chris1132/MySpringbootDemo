package com.chris.demo.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

/**
 * Created by wangchaohui on 2018/6/22.
 */
public class InstanceCounter {
    private static int numInstances = 0;
    private static final Logger log = LoggerFactory.getLogger(InstanceCounter.class);

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
       /* System.out.println("Starting with " +
                InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new InstanceCounter();
        }
        System.out.println("Created " +
                InstanceCounter.getCount() + " instances");*/

        String test = "sad very cool";
        char str[] = {'t', 'y'};
        out.println(sizeEnum.MAX.getVal());

    }
}
