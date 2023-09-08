package org.example.calculator.factory;

import org.example.calculator.CalculatorFactory;
import org.example.calculator.CalculatorService;
import org.example.calculator.operations.Add;

public class AddCalculatorFactory implements CalculatorFactory {
    public CalculatorService createCalculatorService() {
        return new Add();
    }
}
