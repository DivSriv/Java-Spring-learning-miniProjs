package org.example.pred;

import java.util.function.Predicate;

public class Pred {
    static void pred(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }
    public static void main(String[] args)
    {
        Predicate<Integer> predicate = (num) -> num > 7;
        pred(10, predicate);
    }
}
