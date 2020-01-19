package com.kaopuyun.combine.test.utils.object.random.number;

import com.kaopuyun.combine.test.utils.object.random.TypeRandom;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.lang.Long")
public class LongTypeRandom implements TypeRandom<Long> {
    @Override
    public Long get() {
        return new Long(System.nanoTime() >> new Random().nextInt(10));
    }
}
