package com.kaopuyun.combine.test.utils.object.random.number;

import com.kaopuyun.combine.test.utils.object.random.TypeRandom;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.lang.Float")
public class FloatTypeRandom implements TypeRandom<Float> {
    @Override
    public Float get() {
        return new Random().nextFloat();
    }
}
