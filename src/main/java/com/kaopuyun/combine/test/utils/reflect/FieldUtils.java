package com.kaopuyun.combine.test.utils.reflect;

import com.google.common.collect.Sets;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class FieldUtils {
    public final static String GET = "get";
    public final static String SET = "set";


    public static Set<Field> getFields(Class... aClass) {
        Set<Field> result = new HashSet<>();
        if (aClass == null) {
            return result;
        }

        for (Class tClass : aClass) {
            result.addAll(getFields(tClass));
        }
        return result;
    }

    public static <T> Set<Field> getFields(Class<T> aClass) {
        Set<Field> result = new HashSet<>();
        if (aClass != null) {
            Field[] fields = aClass.getDeclaredFields();
            result.addAll(Sets.newHashSet(fields));
            result.addAll(getFields(aClass.getSuperclass()));
        }
        return result;
    }


}
