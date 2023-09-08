package org.example.calculator.factory;

import org.example.calculator.CalculatorFactory;
import org.example.calculator.CalculatorService;
import org.example.calculator.operations.Multiply;

public class MultiplyCalculatorFactory implements CalculatorFactory {
    public CalculatorService createCalculatorService() {
        return new Multiply();
    }
}
