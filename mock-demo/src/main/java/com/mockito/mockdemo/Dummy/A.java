package com.mockito.mockdemo.Dummy;

import org.springframework.stereotype.Component;

@Component("a")
public class A extends AbstractClass{
    @Override
    public void show() {
        System.out.println("in A");
    }
}
