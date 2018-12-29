package com.chris.demo.abstractdemo;

public abstract class AbstractDemo {

    abstract void fun();

    static int index = 1;

    protected void funcTwo() throws RuntimeException {
        System.out.println("abstract funcTwo");
    }
}
