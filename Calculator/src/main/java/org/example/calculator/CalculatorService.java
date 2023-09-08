package org.example.calculator;

import java.util.ArrayList;
import java.util.List;

public interface CalculatorService {
    int calculate(List<Integer> operands);

    static int calculate(String... args) {
//        System.out.println(args[0] instanceof String);
        CalculatorFactory factory = CalculatorFactoryChooser.getFactory(args[0]);

        List<Integer> listOperands = new ArrayList<>();
        for (int i=1; i<args.length; i++) {
            try {
                listOperands.add(Integer.valueOf(args[i]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid operand: " + args[i]);
                System.exit(1);
            }
        }

        CalculatorService calculatorService = factory.createCalculatorService();
        return calculatorService.calculate(listOperands);
    }
}
