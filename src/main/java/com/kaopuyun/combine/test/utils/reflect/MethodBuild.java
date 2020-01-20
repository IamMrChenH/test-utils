package com.kaopuyun.combine.test.utils.reflect;

import javafx.util.Builder;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class MethodBuild implements Builder<Set<Method>> {

    Set<Method> methods;

    public MethodBuild(Class<?> aClass) {
        Assert.notNull(aClass, "MethodBuild 构造方法不允许为参数为空！");
        methods = MethodUtils.getMethods(aClass);
    }

    public MethodBuild(Class<?>[] aClass) {
        Assert.notNull(aClass, "MethodBuild 构造方法不允许为参数为空！");
        methods = MethodUtils.getMethods(aClass);
    }

    public MethodBuild filterStartsWith(String startWidth) {
        methods = MethodUtils.filterStartsWith(methods, startWidth);
        return this;
    }

    /**
     * 交集
     */
    public MethodBuild filterMethodNameDifferent(Collection<Method> methodCollection) {
        methods = MethodUtils.filterMethodNameDifferent(methods, methodCollection);
        return this;
    }


    @Override
    public Set<Method> build() {
        return methods;
    }
}
