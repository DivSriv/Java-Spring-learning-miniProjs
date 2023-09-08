package org.example.calc;

public class DivisionOperator implements Evaluator{

    @Override
    public int calculate(int... values){
        int res = values[0];

        for(int i=1;i<values.length;i++){
//            if(values[i]==0){
//                System.out.println("Division by 0");
//            }
            res = res/values[i];
        }
        return res;
    }
}
