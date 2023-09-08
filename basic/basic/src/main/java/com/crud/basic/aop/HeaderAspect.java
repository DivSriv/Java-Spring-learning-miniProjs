package com.crud.basic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class HeaderAspect {

    @Autowired
    HttpServletRequest request;

    @Before("execution(* com.crud.basic.*.*(..))")
    public void before(){
        String headerValue = request.getHeader("header1");
        System.out.println("\n\n\n The header for the request is" + headerValue);
    }
}
