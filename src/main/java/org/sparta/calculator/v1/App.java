package org.sparta.calculator.v1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //사칙 연산에 사용될 변수 초기화
        int num1 = 0;
        int num2 = 0;
        char operator = ' ';
        boolean value;
        String exit;

        Scanner scanner = new Scanner(System.in);

        // 반복문으로 사칙연산 무한 수행
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
            // 조건문으로 입력값에 따른 계산 기능 구현
            switch (operator) {
                case '+':
                    System.out.println("이정도 계산은 껌이지 ㅋ " + (num1 + num2) + "이니깐 받아 적도록 ~");
                    break;
                case '-':
                    System.out.println("이정도 계산은 껌이지 ㅋ " + (num1 - num2) + "이니깐 받아 적도록 ~");
                    break;
                case '*':
                    System.out.println("이정도 계산은 껌이지 ㅋ " + (num1 * num2) + "이니깐 받아 적도록 ~");
                    break;
                case '/':
                    if (num2 == 0) { //두번째 정수에 0이 입력될수 없음.
                        System.out.println("0으로 나눌줄 몰라용 ~ ");
                    } else {
                        System.out.println("이정도 계산은 껌이지 ㅋ " + (num1 / num2) + "이니깐 받아 적도록 ~");
                    }
                    break;
                default:
            }
            System.out.print("'eixt'을 입력하면 나가게 해줄게 ~");
            exit = scanner.nextLine();
        } while (!exit.equals("exit")); //exit 입력시 반복문 수행 종료

        scanner.close();
        System.out.println("시스템 종료 -_-");
    }
}


