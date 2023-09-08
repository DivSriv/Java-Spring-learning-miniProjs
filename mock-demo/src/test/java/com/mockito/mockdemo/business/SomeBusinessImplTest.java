package com.mockito.mockdemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {
    @Test
    void test(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
//        int result = someBusiness.findTheGreatestFromAllData();
//        assertEquals(25, result);
        System.out.println(someBusiness.findTheGreatestFromAllData());
    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,15,5};
    }
}