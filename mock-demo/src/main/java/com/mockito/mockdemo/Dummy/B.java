package com.mockito.mockdemo.Dummy;

import org.springframework.stereotype.Component;

@Component("b")
public class B extends AbstractClass{
    @Override
    public void show() {
        System.out.println("in B");
    }
}

