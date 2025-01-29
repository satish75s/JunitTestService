package com.junit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.junit.service.JUnitService;

@WebMvcTest(JUnitController.class)  //it tests only controller
@Import(JUnitService.class)
public class JUnitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock  //to simulate the behavior of real objects
    private JUnitService jUnitService;

    @InjectMocks //tells Mockito to inject the mocked dependencies i.e jUnitService, repository etc
    private JUnitController jUnitController;

    @BeforeEach   //it executes before each test method to initialize
    public void setUp() {
        // Mock the JUnitService to return a specific greeting
        when(jUnitService.greet("Infy")).thenReturn("Hello, Infy!");
    }

    @Test
    public void testGreet() throws Exception {
        mockMvc.perform(get("/greet?name=Infy"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, Infy!"));
    }
}
