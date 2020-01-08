package com.kaopuyun.combine.test.utils.object.random;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.util.Date")
public class DateTypeRandom implements TypeRandom<Date> {
    @Override
    public Date get() {
        return new Date();
    }
}
