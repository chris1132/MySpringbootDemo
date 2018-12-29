package com.chris.demo.designpattern.abstract_factory_pattern;

import java.util.HashMap;
import java.util.Map;

public enum ColorTypeEnum {

    RED("red"),
    BLUE("blue");

    private String type;

    ColorTypeEnum(String type) {
        this.type = type;
    }

//    public static final Map<String,ColorTypeEnum> initmap = new HashMap<>();
//
//    static {
//        for(ColorTypeEnum e:values()){
//            initmap.put(e.getType(),e);
//        }
//    }

    public String getType() {
        return type;
    }
}
