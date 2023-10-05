import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
    음식점에서 음식 주문하는 과정 구현
    요구사항
    1. 도메인을 구성하는 객체 고려
        손님, 메뉴판, 메뉴(돈가스/냉면/만두), 요리사, 요리
    2. 객체들 간의 관계
        손님 -- 메뉴판
        손님 -- 요리사
        요리사 -- 요리
    3. 도메인 모델링 - 동적 객체를 정적 타입으로 추상화
        손님 -- 손님 타입
        돈까스/냉면/만두 -- 요리 타입 = 메뉴 -- 메뉴 타입
        메뉴판 -- 메뉴판 타입
    4. 협력
    5. 책임 할당 - 객체를 포괄하는 타입
 */
public class CustomerTest {

    @DisplayName("메뉴 이름에 해당하는 요리를 주문 한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));
        Cooking cooking = new Cooking();

        //고객은 요리 이름, 메뉴, 요리사를 넘긴다
        assertThatCode(()->customer.order("돈까스", menu, cooking))
            .doesNotThrowAnyException();
    }
}
