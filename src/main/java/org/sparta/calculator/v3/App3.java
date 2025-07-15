package org.sparta.calculator.v3;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        // 인스턴스 생성
        Scanner scanner = new Scanner(System.in);
        Calculator<Number> calculator = new Calculator<>();
        CheckValue checkValue = new CheckValue();

        //변수 초기화
        Number num1, num2;
        char operator;

        //계산 실행
        while (true) {
            num1 = checkValue.checkNum(scanner, "첫번째 숫자를 입력 해라! : ");
            num2 = checkValue.checkNum(scanner, "두 번째 숫자를 입력해라! : ");
            operator = checkValue.checkOP(scanner, "연산 기호 입력해 (+, -, *, /) : ");

            try {
                Number result = calculator.calculate(num1, num2, operator);
                System.out.println("이정도 계산은 껌이지 ㅋ " + result + " 이니깐 받아 적도록 ~");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }
            calculator.printResult();
            calculator.deleteResult(scanner, "맨 첫번째 결과값을 삭제 하려면 Yes 라고 입력해줘 ~");
            calculator.searchBigResult(scanner, "값을 주면 너가 준 값보다 큰 수만 보여줄게 ~\n원한다면 Yes를 입력해 :");

            System.out.print("'eixt'을 입력하면 나가게 해줄게 ~");
            if ("exit".equalsIgnoreCase(scanner.nextLine())) break;
        }
    }
}
