package org.sparta.calculator.v2;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char operator = ' ';
        String exit = "";
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        CheckValue checkValue = new CheckValue();

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

            System.out.print("'eixt'을 입력하면 나가게 해줄게 ~");

            exit = scanner.nextLine();

        } while (!exit.equals("exit"));
        scanner.close();
        System.out.println("시스템 종료 -_-");
    }
}