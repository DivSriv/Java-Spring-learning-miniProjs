package com.div.rest.restful.custombean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean("coder")
    Manager buildManager(){
        Responsibility responsibility = new Responsibility(1,"A");
        Manager manager = new Manager("name", responsibility);
        responsibility.setId(67);
        responsibility.setDescription("coder");
        return manager;
    }

    @Bean("guider")
    Manager buildManager1(){
        Manager manager = new Manager();
        Responsibility responsibility = new Responsibility();
        responsibility.setId(65);
        responsibility.setDescription("guider");
        return manager;
    }
}
