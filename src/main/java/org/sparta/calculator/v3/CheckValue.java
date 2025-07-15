package org.sparta.calculator.v3;

import java.util.Scanner;

public class CheckValue{

    //V2와 다르게 문자만 입력 받지 못하도록 수정
    public double checkNum(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("문자는 안돼용 ~ ");
            }
        }
    }

    public char checkOP(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if(input.length()==1 && "+-*/".contains(input)) return input.charAt(0);
            System.out.println("어헛 사칙 연산 기호만 써야지~");
        }
    }
}
