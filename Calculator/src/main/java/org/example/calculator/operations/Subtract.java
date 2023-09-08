package org.example.calculator.operations;

import org.example.calculator.CalculatorService;

import java.util.List;

public class Subtract implements CalculatorService {
    public int calculate(List<Integer> operands) {
        int result = 0;
        for (int operand : operands) {
            result -= operand;
        }
        return result;
    }
}
