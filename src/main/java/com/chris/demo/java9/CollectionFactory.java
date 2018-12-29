package com.chris.demo.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {

    /**
     * Java 9 中，以下方法被添加到 List，Set 和 Map 接口以及它们的重载对象。
     * <p>
     * static <E> List<E> of(E e1, E e2, E e3);
     * static <E> Set<E>  of(E e1, E e2, E e3);
     * static <K,V> Map<K,V> of(K k1, V v1, K k2, V v2, K k3, V v3);
     * static <K,V> Map<K,V> ofEntries(Map.Entry<? extends K,? extends V>... entries)
     */
    public static void main(String[] arg) {
        Set<String> set = Set.of("1", "2", "3");
        List<String> list = List.of("A", "B", "C", "D");
        Map<String, String> map = Map.of("k1", "v1", "k2", "v2", "k3", "v3");

        System.out.println(set);
        System.out.println(list);
        System.out.println(map);
    }
}
