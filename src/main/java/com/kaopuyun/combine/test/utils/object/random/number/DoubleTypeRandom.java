package com.kaopuyun.combine.test.utils.object.random.number;

import com.kaopuyun.combine.test.utils.object.random.TypeRandom;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.lang.Double")
public class DoubleTypeRandom implements TypeRandom<Double> {
    @Override
    public Double get() {
        return new Random().nextDouble();
    }
}
