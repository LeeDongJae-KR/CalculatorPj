package org.sparta.calculator.v3;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OperatorType {
    // 이넘 클래스에 직접 람다 구현
    PLUS('+', (num1, num2) -> num1.doubleValue() + num2.doubleValue()),
    MINUS('-', (num1, num2) -> num1.doubleValue() - num2.doubleValue()),
    MULTI('*', (num1, num2) -> num1.doubleValue() * num2.doubleValue()),
    DIV('/', (num1, num2) -> {
        if (num2.doubleValue() == 0) throw new ArithmeticException("0으로 나눌수 없어요 ~");
        return num1.doubleValue() / num2.doubleValue();
    });

    private final char operator;
    private final Operation<Number> op;

    OperatorType(char operator, Operation<Number> op) {
        this.operator = operator;
        this.op = op;
    }

    // 사용자가 입력한 연산자와 동일한 이넘 인스턴스? 를 찾는 유틸 메서드
    public static OperatorType findOperator(char operator) {

        return Arrays.stream(OperatorType.values()) // enum값 스트림으로 반환
                .filter(x -> x.getOperator() == operator) //원하는 연산자 기호와 일치하는 항목만 필터링
                .findFirst() //가장 먼저 찾은 값 반환
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator));

    }
}
