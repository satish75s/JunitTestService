package com.junit.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JUnitServiceTest {

    @Autowired
    private JUnitService jUnitService;

    @Test
    public void testGreet() {
        String result = jUnitService.greet("Infy");
        assertThat(result).isEqualTo("Hello, Infy!");
    }
}
