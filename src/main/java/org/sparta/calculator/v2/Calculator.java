package org.sparta.calculator.v2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입의 필드
    private List<Integer> result = new ArrayList<>();

    // 양의 정수 2개와 연산 기호를 매개변수 받아 사칙 연산 기능을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) throws RuntimeException {
        int value = 0;

        switch (operator) {
            case '+':
                value = num1 + num2;
                break;
            case '-':
                value = num1 - num2;
                break;
            case '*':
                value = num1 * num2;
                break;
            case '/':
                // 예외처리 --> App2 (책임 분리)
                if (num2 == 0) throw new ArithmeticException("0으로 나눌 수 없어요");
                value = num1 / num2;
                break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자에요");
        }
        result.add(value);
        return value;
    }
}
