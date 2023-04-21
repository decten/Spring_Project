import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴 이름에 해당하는 메뉴를 반환한다")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000),
            new MenuItem("냉면", 7000)));

        MenuItem menuItem = menu.choose("돈까스");
        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }
}
