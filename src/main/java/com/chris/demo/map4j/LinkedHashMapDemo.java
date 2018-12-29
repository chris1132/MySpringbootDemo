package com.chris.demo.map4j;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String arg[]) {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap(16, 0.75F, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eld) {
                return size() > 3;
            }
        };
        linkedHashMap.put("Project1", "1");
        linkedHashMap.put("Project2", "2");
        linkedHashMap.put("Project3", "3");
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println("1--------------1");

        linkedHashMap.get("Project2");
        linkedHashMap.get("Project2");
        linkedHashMap.get("Project3");
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        System.out.println("2--------------2");

        linkedHashMap.put("Project4", "4");
        linkedHashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        System.out.println("hash:" + hashtest("Project4"));
    }

    static final int hashtest(Object key) {
        int h;
        System.out.println(key.hashCode() >>> 16);
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
