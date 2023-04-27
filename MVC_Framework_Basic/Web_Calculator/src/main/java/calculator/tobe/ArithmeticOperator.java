package calculator.tobe;

import java.util.Arrays;

public enum ArithmeticOperator {
    //추상 메소드라 람다로 구성 못 했음
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };
    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    //내부
    protected abstract int arithmeticCalculate(final int operand1, final int operand2);

    //외부 노출
    public static int calculate(int operand1, String para_operator, int operand2) {
        //Optional
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
            //매개변수로 받은 para_operator를 operator에서 찾음
            .filter(v -> v.operator.equals(para_operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        return arithmeticOperator.arithmeticCalculate(operand1,operand2);
    }
}
