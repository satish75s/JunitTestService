package com.junit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junit.service.JUnitService;

@RestController
@RequestMapping
public class JUnitController {
	@Autowired
    private JUnitService jUnitService;

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return jUnitService.greet(name);
    }
}
