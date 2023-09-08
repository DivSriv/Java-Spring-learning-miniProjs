package org.example.calc;

public class MultiplyOperator implements Evaluator{
    @Override
    public int calculate(int... values){
        int res = 1;
        for(int val:values){
            res*=val;
        }
        return res;
    }
}
