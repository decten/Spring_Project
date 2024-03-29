import calculate.PositiveNumber;
import java.util.stream.Stream;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다
 * 양수로만 계산할 수 있다
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생한다
 * MVC 패턴 기반으로 구현한다
 */

public class CalculatorTest {

    @DisplayName("연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaResult")
    void calculationTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result) {
        int calculateResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(calculateResult).isEqualTo(result);
    }
    private static Stream<Arguments> formulaResult(){
        return Stream.of(
            arguments(1,"+",2,3),
            arguments(1,"-",2,-1),
            arguments(4,"*",2,8),
            arguments(4,"/",2,2)
        );
    }
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외가 발생한다")
    @Test
    void calculateExceptionTest(){
        assertThatCode(()->Calculator.calculate(new PositiveNumber(10),"/",new PositiveNumber(0)))
            .isInstanceOf(IllegalArgumentException.class)
            //메시지까지 확인
            .hasMessage("0으로 나눌 수 없습니다.");
    }
}
