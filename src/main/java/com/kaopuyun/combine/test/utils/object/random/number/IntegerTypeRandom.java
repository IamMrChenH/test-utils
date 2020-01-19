package com.kaopuyun.combine.test.utils.object.random.number;

import com.kaopuyun.combine.test.utils.object.random.TypeRandom;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author CHENH
 * @version 1.0
 * @date 2020/01/08
 */
@Component("java.lang.Integer")
public class IntegerTypeRandom implements TypeRandom<Integer> {
    @Override
    public Integer get() {
        return new Random().nextInt();
    }
}
