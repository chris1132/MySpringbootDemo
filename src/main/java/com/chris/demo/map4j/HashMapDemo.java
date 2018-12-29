package com.chris.demo.map4j;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {

    static final int HASH_BITS = 0x7fffffff;

    public static void main(String arg[]) {

        HashMap<MapKey, String> hashMap = new HashMap();

        for (int i = 0; i < 50; i++) {
            hashMap.put(new MapKey(String.valueOf(i)), "A");
        }
        String h = "key";
        int index;
        // System.out.println((index= h.hashCode()) ^ (index >>> 16));
        System.out.println(spread(h.hashCode()));

        var currentHashmap = new ConcurrentHashMap<String, String>();
        currentHashmap.put(h, "1132");
    }

    static final int spread(int h) {
        System.out.println(h);
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
