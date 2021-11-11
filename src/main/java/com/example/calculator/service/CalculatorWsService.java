package com.example.calculator.service;

import com.example.calculator.ws.CalculatorWsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorWsService {

    private final CalculatorWsClient calculatorWsClient;

    @Autowired
    public CalculatorWsService(CalculatorWsClient calculatorWsClient) {
        this.calculatorWsClient = calculatorWsClient;
    }

    public int add(final int first, final int second) {
        return calculatorWsClient.add(first, second).getAddResult();
    }

    public int subtract(final int first, final int second) {
        return calculatorWsClient.subtract(first, second).getSubtractResult();
    }

    public int multiply(final int first, final int second) {
        return calculatorWsClient.multiply(first, second).getMultiplyResult();
    }

    public int divide(final int first, final int second) {
        return calculatorWsClient.divide(first, second).getDivideResult();
    }
}
