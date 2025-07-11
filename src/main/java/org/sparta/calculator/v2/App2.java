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


        boolean value = true;
        do {
            value = false;
            while (!value) {
                try {   //예외 처리로 정수 이외의 값을 받지 못하게 구현
                    System.out.print("첫번째 숫자를 입력 해라! : ");
                    num1 = Integer.parseInt(scanner.nextLine());
                    value = true;
                } catch (NumberFormatException e) {
                    System.out.println("실수나 문자는 안돼용 ~ ");
                }
            }

            value = false;
            while (!value) {
                try {
                    System.out.print("두 번째 숫자를 입력해라! : ");
                    num2 = Integer.parseInt(scanner.nextLine());
                    value = true;
                } catch (NumberFormatException e) {
                    System.out.println("실수나 문자는 안돼용 ~ ");
                }
            }

            value = false;
            while (!value) {
                System.out.print("사칙연산 기호(+, -, *, /)를 입력해보게나! : ");
                String input = scanner.nextLine();
                // 조건문으로 사칙연산 기호 이외의 값은 받지 못하도록 구현
                if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                    operator = input.charAt(0);
                    value = true;
                } else {
                    System.out.println("어헛 사칙 연산 기호만 써야지~");
                }
            }
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