package org.example.calculator.domain;

import org.example.calculator.tobe.AdditionOperator;
import org.example.calculator.tobe.DivisionOperator;
import org.example.calculator.tobe.MultiplicationOperator;
import org.example.calculator.tobe.SubtractionOperator;
import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
        new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        //operator에 맞는 인터페이스 구현체를 찾음
        return arithmeticOperators.stream().filter(arithmeticOperators -> arithmeticOperators.supports(operator))
            //찾은 구현체로 계산함
            .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
