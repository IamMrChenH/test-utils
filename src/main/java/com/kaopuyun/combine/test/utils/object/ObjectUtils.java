package com.kaopuyun.combine.test.utils.object;

import com.kaopuyun.combine.test.utils.reflect.FieldUtils;
import com.kaopuyun.combine.test.utils.object.random.TypeToRandomContext;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
public class ObjectUtils {

    private static TypeToRandomContext typeToRandomContext = new TypeToRandomContext();

    private static Object newInstance(Object object, Class<?> aClass) {
        Assert.notNull(aClass, "不能输入空class！");
        Object reusult = object;
        try {
            if (object == null) {
                reusult = aClass.newInstance();
            }

            Set<Field> fields = FieldUtils.getFields(aClass);
            for (Field field : fields) {
                setFieldRandomValue(reusult, field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reusult;
    }

    public static <T> T newInstance(Class<T> aClass) {
        return (T) newInstance(null, aClass);
    }

    public static <T> T newInstance(T object) {
        return (T) newInstance(object, object.getClass());
    }


    private static <T> void setFieldRandomValue(T reusult, Field field) throws IllegalAccessException {
        setFieldValue(reusult, field, typeToRandomContext.get(field.getType()));
    }

    private static <T> void setFieldValue(T reusult, Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(reusult) == null) {
            field.set(reusult, object);
        }
    }


}
