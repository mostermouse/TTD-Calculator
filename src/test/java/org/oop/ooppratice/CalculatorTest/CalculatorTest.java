package org.oop.ooppratice.CalculatorTest;

import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.oop.ooppratice.Calculator.Calculator;
import org.oop.ooppratice.Calculator.operator.PositiveNumber;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산 가능
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킴
 * mvc패턴 기반 구현
 * */
public class CalculatorTest {


    //1 +2 --> Calculator
    //  3   <--
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(calculateResult).isEqualTo(result);

    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)

        );

    }

   /* @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateException() {
        assertThatCode(()->Calculator.calculate(new PositiveNumber(10), "/" , new PositiveNumber(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");


    }
*/
}
