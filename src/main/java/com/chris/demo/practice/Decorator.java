package com.chris.demo.practice;

public class Decorator implements Component {

    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void Operation() {
        component.Operation();
    }

}
