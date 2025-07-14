package org.sparta.calculator.v2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입의 필드
    List<Integer> result = new ArrayList<>();

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

    // 리스트에 저장된 첫번째 값 삭제 메서드
    public boolean deleteResult(Scanner scanner, String pompt) {
        System.out.print(pompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Yes")) {
            if (!result.isEmpty()) {
                int deleted = result.remove(0);
                System.out.println("첫 번째 결과(" + deleted + ") 를 삭제 했다잇!");
            } else {
                System.out.println("삭제할게 없는데? ");
            }
            return true;
        }
        return false;
    }

    // 리스트에 저장된 값 정리해서 출력
    public void printResults() {
        if (!result.isEmpty()) {
            System.out.println("저장된 결과 리스트");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((i + 1) + "번째 : " + result.get(i));
            }
        } else {
            System.out.println("저장된 결과가 없는데?");
        }
    }
}
