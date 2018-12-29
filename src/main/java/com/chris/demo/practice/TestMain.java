package com.chris.demo.practice;

public class TestMain {

    public static void main(String arg[]) {


        Component component = new ConcreteComponet();

        Component componentDecorator = new ConcreteDecoratorA(component);

        componentDecorator.Operation();

    }
}
