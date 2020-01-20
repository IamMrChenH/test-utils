package com.kaopuyun.combine.test.utils.reflect;

import com.google.common.collect.Sets;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class MethodUtils {

    /**
     * 获取类的所有方法
     */
    public static Set<Method> getMethods(Class<?>... aClass) {
        Set<Method> methods = Sets.newHashSet();
        if (aClass == null) {
            return methods;
        }
        for (Class<?> aClass1 : aClass) {
            methods.addAll(getMethods(aClass1));
        }
        return methods;
    }

    public static Set<Method> getMethods(Class<?> aClass) {
        Set<Method> methods = Sets.newHashSet();
        if (aClass != null) {
            methods.addAll(Sets.newHashSet(aClass.getMethods()));
            methods.addAll(getMethods(aClass.getSuperclass()));
        }
        return methods;
    }

    public static Set<Method> filterStartsWith(Collection<Method> methods, String startWith) {
        return methods.stream()
                .filter(method -> method.getName().startsWith(startWith))
                .collect(Collectors.toSet());
    }


    public static Set<Method> filterMethodNameDifferent(Collection<Method> methods, Collection<Method> methodCollection) {
        Assert.notEmpty(methods, "methods 集合不能为空！");
        Assert.notEmpty(methodCollection, "methodCollection 集合不能为空！");

        Set<String> collect = methodCollection.stream().map(method -> method.getName()).collect(Collectors.toSet());
        return methods.stream().filter(method -> collect.contains(method.getName())).collect(Collectors.toSet());
    }

    public static <T> Class<T> getReturnClass(Method method) {
        return (Class<T>) method.getReturnType();
    }

    public static Class[] getParameterClass(Method method) {
        return method.getParameterTypes();
    }

    public static String getClassPackageName(Class aClass) {
        Assert.notNull(aClass, "getClassPackageName : aClass 不能为空！");
        return new StringBuilder(aClass.getName()).toString();
    }

    public static Set<String> getClassPackageName(Class... aClass) {
        Assert.notNull(aClass, "getMethodReturnClassPageackName : aClass 不能为空！");
        Set<String> result = Sets.newHashSet();
        for (Class aClass1 : aClass) {
            result.add(getClassPackageName(aClass1));
        }
        return result;
    }

}
