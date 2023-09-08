package com.spring.basics.springsteps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSortAlgo implements SortAlgo{
    public int[] sort(int[] numbers){
        //Quick
        return numbers;
    };
}
