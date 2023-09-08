package org.example.calculator.factory;

import org.example.calculator.CalculatorFactory;
import org.example.calculator.CalculatorService;
import org.example.calculator.operations.Subtract;

public class SubtractCalculatorFactory implements CalculatorFactory {
    public CalculatorService createCalculatorService() {
        return new Subtract();
    }
}
