package org.sparta.calculator.v2;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {

        // 사칙 연산에 사용될 변수 초기화
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char operator = ' ';
        String exit = "";

        // 사칙 연산에 사용될 객체 선언
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        CheckValue checkValue = new CheckValue();

        // 압력값 검증 및 사칙연산 수행
        do {
            num1 = checkValue.checkNum(scanner,"첫 번째 숫자를 입력해라! : ");
            num2 = checkValue.checkNum(scanner, "두 번째 숫자를 입력해라! : ");
            operator = checkValue.checkOP(scanner, "사칙연산 기호(+, -, *, /)를 입력해보게나! : ");

            try {
                result = calculator.calculate(num1, num2, operator);
                System.out.println("이정도 계산은 껌이지 " + result + " 이니깐 받아 적도록~");
            }catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // 계산된 결과값 출력 및 처음값 삭제
            calculator.printResults();
            calculator.deleteResult(scanner, "맨 첫번째 결과값을 삭제 하려면 Yes 라고 입력해줘 ~");
            calculator.printResults();

            System.out.print("'Eixt'을 입력하면 나가게 해줄게 ~");

            exit = scanner.nextLine();

        } while (!exit.equalsIgnoreCase("exit"));
        scanner.close();
        System.out.println("시스템 종료 -_-");
    }
}