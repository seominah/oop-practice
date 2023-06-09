package org.example.calculator;

import org.example.calculator.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {
    // 1 + 2 ----> calculator
    //   3   <----
    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void additionTest(int operand1, String operator, int operand2, int result) {
        int calculatorResult = Calculator.calculator(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        assertThat(calculatorResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(5, "-", 2, 3),
                arguments(4, "*", 2, 8),
                arguments(8, "/", 2, 4)
        );
    }

//    @DisplayName("나눗셈에서 0을 나누는 경우 예외를 발생시킨다.")
//    @Test
//    void calculateExceptionTest(){
//        assertThatCode(()->Calculator.calculator(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
