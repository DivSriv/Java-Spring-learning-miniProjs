package com.mockito.mockdemo.Dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instance {

    @Autowired
    @Qualifier("a")
    private AbstractClass c1;

    public void display(){
        System.out.println("inside Instance : "+c1);
        c1.show();
    }
}
