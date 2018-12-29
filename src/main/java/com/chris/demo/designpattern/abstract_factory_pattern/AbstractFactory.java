package com.chris.demo.designpattern.abstract_factory_pattern;

import com.chris.demo.designpattern.factory_pattern.Shape;

public abstract class AbstractFactory {

    public abstract Shape getShape(String shapeType);

    public abstract Color getColor(String colorType);
}
