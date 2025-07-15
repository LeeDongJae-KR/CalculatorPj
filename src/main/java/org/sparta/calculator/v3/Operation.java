package org.sparta.calculator.v3;

import java.math.BigDecimal;

@FunctionalInterface
public interface Operation<N extends Number> {
     N calculate(N num1, N num2);
}
