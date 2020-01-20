package com.kaopuyun.combine.test.utils;

import com.google.common.collect.Sets;
import com.kaopuyun.combine.test.utils.reflect.MethodUtils;
import javafx.util.Builder;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class AssertClassBuilder implements Builder<String> {

    private static final String CODE_TEMP = "%s\n\n@RunWith(MockitoJUnitRunner.class)\npublic class %sTest {\n%s\n}\n";

    private Class aClass;

    public AssertClassBuilder(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String build() {
        String mapper = String.format("\t@Spy\n\tprivate %sImpl %s;\n", aClass.getSimpleName(), "mapper");
        Set<Method> methods = MethodUtils.getMethods(aClass);
        StringBuilder builder = new StringBuilder();
        builder.append(mapper);
        methods.forEach(method -> builder.append(new AssertMethodBuilder(method).build()));

        //获取包
        Set<String> packageNames = Sets.newHashSet("org.mockito.*", "org.junit.*",
                "org.assertj.core.api.*");

        for (Method method : methods) {
            packageNames.add(MethodUtils.getClassPackageName(method.getReturnType()));
            packageNames.addAll(MethodUtils.getClassPackageName(method.getParameterTypes()));
        }

        StringBuilder packageBuilder = new StringBuilder();
        packageBuilder.append(aClass.getPackage()).append(";\n");
        for (String packageName : packageNames) {
            packageBuilder.append("import ").append(packageName).append(";\n");
        }

        return String.format(CODE_TEMP, packageBuilder.toString(), aClass.getSimpleName(), builder.toString());
    }


}
