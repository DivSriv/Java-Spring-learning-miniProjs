package com.mockito.mockdemo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int[] data = dataService.retrieveAllData();
        int greatestVal = Integer.MIN_VALUE;

        for(int value:data){
            if(value>greatestVal){greatestVal=value;}
        }
        return greatestVal;
    }
}

interface DataService{
    int[] retrieveAllData();
}