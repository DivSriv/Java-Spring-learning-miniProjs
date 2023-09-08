package com.spring.aop.aop.custombean;

public class Manager {
    private String name;

    Responsibility responsibility;

    public Manager() {
    }

    public Manager(String name, Responsibility responsibility) {
        this.name = name;
        this.responsibility = responsibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Responsibility getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }
}
