package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.ReqeustLine;
import org.junit.jupiter.api.Test;

public class ReqeustLineTest {

    @Test
    void create() {
        ReqeustLine reqeustLine = new ReqeustLine("GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1");

        assertThat(reqeustLine).isNotNull();
    }
}
