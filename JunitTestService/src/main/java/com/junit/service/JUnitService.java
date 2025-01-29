package com.junit.service;

import org.springframework.stereotype.Service;

@Service
public class JUnitService {

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
