package org.example.calc;

public class SubtractOperator implements  Evaluator{
    @Override
    public int calculate(int... values){
        int res = values[0];
        for(int val:values){
            res-=val;
        }
        return res;
    }
}
