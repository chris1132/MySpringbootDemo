package com.chris.demo.designpattern.factory_pattern;

import com.chris.demo.designpattern.abstract_factory_pattern.AbstractFactory;
import com.chris.demo.designpattern.abstract_factory_pattern.Color;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        } else if (shapeType.equalsIgnoreCase(ShapeTypeEnum.CIRCLE.getType())) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase(ShapeTypeEnum.SQUARE.getType())) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
