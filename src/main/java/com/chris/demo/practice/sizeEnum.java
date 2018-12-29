package com.chris.demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchaohui on 2018/7/13.
 */
public enum sizeEnum {

    SMALL("small"),
    MIDEUM("med"),
    MAX("max");

    private String val;

    private sizeEnum(String val) {
        this.val = val;
    }

    private static final Map<String, sizeEnum> inimap = new HashMap<String, sizeEnum>();

    static {
        for (sizeEnum se : values()) {
            inimap.put(se.val, se);
        }
    }

    public String getVal() {
        return val;
    }
}
