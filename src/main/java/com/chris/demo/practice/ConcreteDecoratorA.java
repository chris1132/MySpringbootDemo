package com.chris.demo.practice;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        super.Operation();
        this.PrintInfo();
    }

    public void PrintInfo() {

        System.out.println("add print info");
    }
}
