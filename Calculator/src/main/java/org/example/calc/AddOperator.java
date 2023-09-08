package org.example.calc;

public class AddOperator implements Evaluator{
    @Override
    public int calculate(int... values){
        int sum=0;
        for(int val : values){
            sum+=val;
        }
        return sum;
    }

}
