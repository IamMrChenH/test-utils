package com.kaopuyun.combine.test.utils;

import javafx.util.Builder;

import java.lang.reflect.Method;

/**
 * @author chenh
 * @date 2020年01月20日
 */
public class AssertLineBuilder implements Builder<String> {
    private static final String CODE_TEMP = "\t\tAssertions.assertThat(target.%s()).isEqualTo(source.%s());\n";

    private Method method;

    public AssertLineBuilder(Method method) {
        this.method = method;
    }

    @Override
    public String build() {
        return String.format(CODE_TEMP, method.getName(), method.getName());
    }
}
