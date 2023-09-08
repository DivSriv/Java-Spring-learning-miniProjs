package com.example.cache;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
public class Service {
    static int i=0;

    @Cacheable(value = "addresses", key = "#customer.address")
    public String getAddress(Customer customer){
        System.out.println("method is called"+ i++);
        return customer.address;
    }

    @CachePut(value = "addresses", key = "#customer.address")
    public String updateAddress(Customer customer){
        System.out.println("method is called"+ i++);

        return customer.updateAddress(customer.address);
    }

    @CacheEvict(value = "addresses", allEntries = true)
    public String setAddress(Customer customer){

        return customer.updateAddress(customer.address);
    }
    @CacheEvict(value = "addresses", key="#customer.address")
    public void update(Customer customer){

        System.out.println("Evicted one particular key");
    }
}
