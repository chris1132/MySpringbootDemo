package com.chris.demo.practice;

/**
 * Created by wangchaohui on 2018/7/17.
 */
public class GenericTest {


    public static void main(String arg[]) {
        Generic<String> g_str = new Generic<>("name");
        Generic<Integer> g_int = new Generic<>(123);

    }
}
