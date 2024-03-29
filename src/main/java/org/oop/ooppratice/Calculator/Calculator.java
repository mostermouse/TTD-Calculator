package org.oop.ooppratice.Calculator;

import org.oop.ooppratice.Calculator.operator.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator() , new DivisionOperator());
    public static int calculate(PositiveNumber operrand1, String operrator, PositiveNumber operrnad2) {

        return arithmeticOperators.stream()
               .filter(arithmeticOperator -> arithmeticOperator.supports(operrator))
               .map(arithmeticOperator -> arithmeticOperator.calculate(operrand1,operrnad2))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));

    }
}
