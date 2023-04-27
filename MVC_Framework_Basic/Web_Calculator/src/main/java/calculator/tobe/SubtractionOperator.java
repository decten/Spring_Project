package calculator.tobe;

import calculator.domain.NewArithmeticOperator;
import calculator.domain.PositiveNumber;

public class SubtractionOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt()-operand2.toInt();
    }
}