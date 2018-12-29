package com.chris.demo.abstractdemo;

public class AbstractChildDemo extends AbstractDemo {

    @Override
    public void fun() {
        System.out.println("func");
        int i = AbstractDemo.index;
        System.out.println(i);
    }

    @Override
    public void funcTwo() {
        System.out.println("abstract funTwo 2");
    }


    public void funcThree() {
        System.out.println("abstract funThree");
    }
}
