package org.example.calculator;

import org.example.calculator.factory.AddCalculatorFactory;
import org.example.calculator.factory.DivideCalculatorFactory;
import org.example.calculator.factory.MultiplyCalculatorFactory;
import org.example.calculator.factory.SubtractCalculatorFactory;

public class CalculatorFactoryChooser {
    public static CalculatorFactory getFactory(String operator) {
        System.out.println(operator instanceof String);
        switch (operator) {
            case "+":
                return new AddCalculatorFactory();
            case "-":
                return new SubtractCalculatorFactory();
            case "*":
                return new MultiplyCalculatorFactory();
            case "/":
                return new DivideCalculatorFactory();
            default:
                System.out.println("Invalid operator: " + operator);
                System.exit(1);
                return null;
        }
    }
}
