package com.example.cache;

public class Customer {
    public String address;

    public Customer() {
    }

    public Customer(String address) {
        this.address = address;
    }

    public String updateAddress(String newAddress) {
        address = newAddress;
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
