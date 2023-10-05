package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QueryStringTest {
    //쿼리 스트링 여러 개를 다루기 위해 List<QueryString> -> 1급 컬렉션
    //operand1=11
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1", "11");

        assertThat(queryString).isNotNull();
    }
}
