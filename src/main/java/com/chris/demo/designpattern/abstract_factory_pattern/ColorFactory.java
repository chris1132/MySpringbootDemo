package com.chris.demo.designpattern.abstract_factory_pattern;

import com.chris.demo.designpattern.factory_pattern.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        if (null == colorType) {
            return null;
        } else if (colorType.equalsIgnoreCase(ColorTypeEnum.RED.getType())) {
            return new Red();
        } else if (colorType.equalsIgnoreCase(ColorTypeEnum.BLUE.getType())) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
