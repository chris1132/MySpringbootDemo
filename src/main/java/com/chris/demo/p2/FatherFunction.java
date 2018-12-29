package com.chris.demo.p2;

public class FatherFunction {

    static int a = 1;

    static {

        a = 2;
        System.out.println("father:" + a);
    }

    public FatherFunction() {
        System.out.println("father 2:" + a);
    }


}
