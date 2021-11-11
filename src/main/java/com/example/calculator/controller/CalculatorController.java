package com.example.calculator.controller;

import com.example.calculator.service.CalculatorWsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorWsService calculatorWsService;

    @Autowired
    public CalculatorController(CalculatorWsService calculatorWsService) {
        this.calculatorWsService = calculatorWsService;
    }

    @GetMapping("/add")
    public int add(@RequestParam int first, @RequestParam int second) {
        return calculatorWsService.add(first, second);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int first, @RequestParam int second) {
        return calculatorWsService.subtract(first, second);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int first, @RequestParam int second) {
        return calculatorWsService.multiply(first, second);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int first, @RequestParam int second) {
        if (second == 0) {
            throw new RuntimeException("Деление на ноль");
        }
        return calculatorWsService.divide(first, second);
    }
}

