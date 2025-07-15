# CalculatorPj

Java 콘솔 기반 계산기 프로젝트 (v1 → v2 → v3)입니다.
Enum, 람다, 스트림, 제네릭 등 최신 Java 문법과 객체지향 설계를 익히기 위해 단계적으로 구현했습니다.

## 🚀 버전 히스토리

### v1
App 클래스 하나에 모든 로직 집중
Scanner + nextLine() 반복문 기반 입력 및 기본 예외 처리
### v2
Calculator, CheckValue, App2로 클래스 분리
Calculator.calculate() 메서드 구현 + 결과 저장 기능
CheckValue로 입력 검증 책임(예외 처리) 이동
switch + throw로 예외 처리 구조 분리
### v3 (현재 버전)
Enum + 람다로 계산 연산 전략 구현 (OperatorType)
Operation<N extends Number> 인터페이스 + 제네릭 지원
결과 저장, 삭제, 조건 검색 등 기능 강화

## ✅ 주요 기능
- 사칙연산: +, -, *, /
- 정수 / 실수 입력 모두 가능 (double)
- 0으로 나누기 오류 처리
- 계산 결과 저장 및 보기
- 첫 번째 결과 삭제 기능
- 기준 값보다 큰 결과만 필터링 출력
- 결과값 출력 시 인덱스/포맷 적용 (IntStream)

## 📂 프로젝트 구조

```bash
src/
└─ main/java/org/sparta/calculator/v3/
   ├─ App3.java             // 메인 실행 클래스
   ├─ Calculator.java       // 제네릭 계산기, Stream 처리 포함
   ├─ CheckValue.java       // 입력값 검증 (숫자, 연산자)
   ├─ OperatorType.java     // Enum + 람다 기반 연산 전략
   └─ Operation.java        // 함수형 인터페이스 (람다 target)

```
## 📌 사용 예시

안내에 따라 숫자 및 연산자 입력

첫번째 숫자 입력: 5
두 번째 숫자 입력: 3
연산자 입력(+,-,*,/): *
이정도 계산은 껌이지 ㅋ 15.0 이니깐 받아 적도록 ~

저장된 결과 리스트를 보여줄게 ~ 1번째: 15.0
맨 첫번째 결과값을 삭제 하려면 Yes 라고 입력해줘 ~ yes
첫 번째 결과(15.0) 를 삭제 했다잇!
저장된 결과 리스트를 보여줄게 ~ 

값을 주면 너가 준 값보다 큰 수만 보여줄게 ~
원한다면 Yes를 입력해 : no
exit 입력 시 종료, 계속하려면 Enter: exit

## 📌 코드 설명 포인트

1. OperatorType + 람다
PLUS('+', (num1, num2) -> num1.doubleValue() + num2.doubleValue())
람다식으로 연산 로직 삽입
doubleValue() 사용해 숫자 타입 통일

2. 함수형 인터페이스 Operation<N>
@FunctionalInterface
public interface Operation<N> {
    double calculate(N a, N b);
}
람다식을 위한 구조적 기반 제공

3. Calculator<N> 클래스
calculate() 메서드: Enum 기반 계산 + 결과 저장
printResult(): IntStream + Collectors.joining()으로 예쁜 출력
deleteResult(), searchBigResult(): 결과 관리 기능

4. CheckValue
숫자 입력: Double.parseDouble() + 반복 검증
연산자 입력: 길이 및 "+-*/" 포함 여부 체크

## 🌱 배운 점 / 향후 개선
- Enum + 람다	계산 로직 모듈화 및 전략 분리
- 제네릭	다양한 숫자 타입 지원
- Stream API	리스트 출력, 필터링 간결하게 구현
- 소수점 자리수 제어	DecimalFormat 도입 필요

## 📚 참고 링크
Java 공식 문서: [Enum](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html), [Lambda](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html), [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
