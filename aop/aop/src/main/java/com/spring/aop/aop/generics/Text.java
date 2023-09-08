package com.spring.aop.aop.generics;

import java.util.ArrayList;

public class Text<T>{
    T name;

    ArrayList<T> list;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
