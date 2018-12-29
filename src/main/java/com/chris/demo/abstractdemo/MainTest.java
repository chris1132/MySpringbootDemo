package com.chris.demo.abstractdemo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainTest {

    public static void main(String[] arg) {
        AbstractDemo abstractDemo = new AbstractChildDemo();
        abstractDemo.fun();
        abstractDemo.funcTwo();
        ((AbstractChildDemo) abstractDemo).funcThree();

    }

}
