package com.chris.demo.p2;

public class ChildFunction extends FatherFunction {

    static int b = 3;

    static {
        b = 4;
        System.out.println("child:" + b);

    }

    public static void main(String arg[]) {
        System.out.println("child 2:" + b);
    }
}
