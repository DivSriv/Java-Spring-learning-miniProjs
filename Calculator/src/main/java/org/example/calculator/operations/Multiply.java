
package org.example.calculator.operations;

import org.example.calculator.CalculatorService;

import java.util.List;

public class Multiply implements CalculatorService {
    public int calculate(List<Integer> operands) {
        int result = 1;
        for (int operand : operands) {
            result *= operand;
        }
        return result;
    }
}
