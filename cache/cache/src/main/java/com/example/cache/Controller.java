package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Service service;

    @GetMapping("/update")
    public String runner(){
        return service.getAddress(new Customer("Freecharge"));
    }

    @GetMapping("/delete")
    public void runnerDel(){
        service.update(new Customer("Freecharge"));
    }
}
