package com.chris.demo.designpattern.abstract_factory_pattern;

import com.chris.demo.designpattern.factory_pattern.ShapeFactory;

public class FactoryProducer {


    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (type.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
