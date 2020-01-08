package com.kaopuyun.combine.test.utils.object.random;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.lang.String")
public class StringTypeRandom implements TypeRandom<String> {
    @Override
    public String get() {
        return UUID.randomUUID().toString();
    }
}
