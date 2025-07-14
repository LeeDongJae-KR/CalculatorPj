package org.sparta.calculator.v2;

import java.util.Scanner;

public class CheckValue {

    public int checkNum(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("실수나 문자는 안돼용 ~ ");
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

