package com.chris.demo.designpattern.factory_pattern;

import java.util.HashMap;
import java.util.Map;

public enum ShapeTypeEnum {

    CIRCLE("circle"),
    SQUARE("square");

    private String type;

    ShapeTypeEnum(String type) {
        this.type = type;
    }

//    public static final Map<String,ShapeTypeEnum> initmap = new HashMap<>();
//
//    static{
//        for(ShapeTypeEnum e:values()){
//            initmap.put(e.type,e);
//        }
//    }

    public String getType() {
        return type;
    }
}
