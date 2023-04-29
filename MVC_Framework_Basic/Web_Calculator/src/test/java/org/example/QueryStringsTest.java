package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QueryStringsTest {

    @Test
    void createTest() {
        //QueryStrings는 여러 개의 쿼리 스트링을 갖는 1급 컬렉션
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");

        assertThat(queryStrings).isNotNull();
    }
}
