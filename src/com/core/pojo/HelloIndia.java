package com.core.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Required;

public class HelloIndia {
    private String message1;
    private String message2;
    private String message3;

    @Required
    public void setMessage1(String message) {
        this.message1 = message;
    }

    @Required
    public void setMessage2(String message) {
        this.message2 = message;
    }

    @Required
    public void setMessage3(String message) {
        this.message3 = message;
    }

    public void getMessage1() {
        System.out.println("India Message1 : " + message1);
    }

    public void getMessage2() {
        System.out.println("India Message2 : " + message2);
    }

    public void getMessage3() {
        System.out.println("India Message3 : " + message3);
    }

    @PostConstruct
    public void init() {
        System.out.println("HelloIndia is going through init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("HelloIndia will destroy now.");
    }
}