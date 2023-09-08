package org.example.calculator.operations;

import org.example.calculator.CalculatorService;

import java.util.List;

public class Divide implements CalculatorService {
    public int calculate(List<Integer> operands) {
        int result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            int operand = operands.get(i);
            result /= operand;
        }
        return result;
    }
}