package org.example;

import org.example.calc.*;
import org.example.calculator.CalculatorService;

import java.util.Scanner;


public class Client {
    public static void main(String[] args){

        int result = CalculatorService.calculate("+", "1", "2", "3");
        System.out.println(result);


    }
}