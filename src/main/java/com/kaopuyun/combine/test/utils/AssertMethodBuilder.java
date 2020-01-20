package com.kaopuyun.combine.test.utils;

import com.kaopuyun.combine.test.utils.object.ObjectUtils;
import com.kaopuyun.combine.test.utils.reflect.FieldUtils;
import com.kaopuyun.combine.test.utils.reflect.MethodBuild;
import com.kaopuyun.combine.test.utils.reflect.MethodUtils;
import javafx.util.Builder;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class AssertMethodBuilder implements Builder<String> {

    private static final String CODE_TEMP = "\n\t@Test\n\tpublic void %s() throws Exception {\n%s\t}\n";

    private Method method;

    public AssertMethodBuilder(Method method) {
        this.method = method;
    }

    @Override
    public String build() {
        Class<?> returnType = method.getReturnType();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Set<Method> returnMethods = new MethodBuild(returnType).filterStartsWith("get").build();
        Set<Method> parameterMethods = new MethodBuild(parameterTypes).filterStartsWith("get").build();
        Set<Method> identicalMethods = MethodUtils.filterMethodNameDifferent(returnMethods, parameterMethods);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            builder.append("\t\t").append(parameterType.getSimpleName())
                    .append(" source = ObjectUtils.newInstance(Mockito.spy(")
                    .append(parameterType.getSimpleName()).append(".class));\n");
        }

        builder.append("\t\t").append(returnType.getSimpleName()).append(" target = mapper.")
                .append(method.getName()).append("(source);\n");

        identicalMethods.forEach(method1 -> builder.append(new AssertLineBuilder(method1).build()));
        return String.format(CODE_TEMP, method.getName(), builder.toString());
    }
}
