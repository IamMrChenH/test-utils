package com.kaopuyun.combine.test.utils.object.random;

import java.util.*;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
public class TypeToRandomContext {

    private Map<String, TypeRandom> randomMap = new HashMap<>();
    Set<String> basicTypes = new HashSet();

    public TypeToRandomContext() {
        randomMap.put(Date.class.getName(), new DateTypeRandom());
        randomMap.put(Long.class.getName(), new LongTypeRandom());
        randomMap.put(String.class.getName(), new StringTypeRandom());

        basicTypes.add("long");
        basicTypes.add("int");
        basicTypes.add("short");

    }

    public Object get(Class<?> type) {
        String key = type.getName();
        if (basicTypes.contains(key)) {
            key = "java.lang.Long";
        }
        return randomMap.get(key).get();
    }
}
