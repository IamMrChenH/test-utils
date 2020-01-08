package com.kaopuyun.combine.test.utils.object;

import com.kaopuyun.combine.test.utils.object.random.TypeToRandomContext;
import com.google.common.collect.Sets;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
public class ObjectUtils {

    private static TypeToRandomContext typeToRandomContext = new TypeToRandomContext();

    public static <T> T newInstance(Class<T> aClass) {
        T reusult = null;
        try {
            reusult = aClass.newInstance();
            Set<Field> fields = getFields(aClass);
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(reusult, typeToRandomContext.get(field.getType()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reusult;
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
