package org.sparta.calculator.v3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator<N extends Number> {

    // 결과값을 기록할 리스트 생성
    private List<Number> results = new ArrayList<>();

    // 사칙 연산 수행 메서드
    public Number calculate(N num1, N num2, char operator) {
        OperatorType operatorType = OperatorType.findOperator(operator);
        Number result = operatorType.getOp().calculate(num1, num2);
        results.add(result);
        return result;
    }

    // 기록된 값을 보기 좋게 출력
    public void printResult() {
        if (!results.isEmpty()) {
            //IntStream.range() / AtomicInteger 사용법도 있다고함
            String output = IntStream.range(0, results.size()) // 인덱스 0부터 리스크 크기까지 반복
                    .mapToObj(i -> (i + 1) + "번째: " + results.get(i)) // 인덱스 + 값 (스트림으로 반환)
                    .collect(Collectors.joining(", ")); //문자열 한줄로 합치기
            System.out.println("저장된 결과 리스트를 보여줄게 ~ " + output);

        } else System.out.println("저장된 결과가 없어욧~");
    }

    // 가장 먼저 기록된 값을 삭제하는 메서드
    public boolean deleteResult(Scanner scanner, String pompt) {
        System.out.print(pompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Yes")) {
            if (!results.isEmpty()) {
                Number deleted = results.remove(0);
                System.out.println("첫 번째 결과(" + deleted + ") 를 삭제 했다잇!");
                printResult();
            } else {
                System.out.println("삭제할게 없는데? ");
            }
            return true;
        }
        return false;
    }

    // 리스트에 저장된 값중에 사용자가 입력한 값보다 큰 값을 출력
    public void searchBigResult(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("Yes")) {
            while (true) {
                System.out.println("숫자를 입력해 보도록 :");
                String query = scanner.nextLine().trim();

                try {
                    double threshold = Double.parseDouble(query);
                    List<Number> bigResult = results.stream()
                            .filter(i -> i.doubleValue() > threshold)
                            .toList();
                    System.out.println("=== 결과는 === \n" + bigResult);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해야지~");
                }
            }
        }
    }
}


