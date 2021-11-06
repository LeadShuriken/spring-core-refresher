package com.tutorialspoint;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

@Configuration
public class ContextEvent implements ApplicationListener<ContextClosedEvent> {

    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("----------------------------");
        System.out.println("ContextStartedEvent Received");
        System.out.println("----------------------------");
    }

    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("----------------------------");
        System.out.println("ContextStoppedEvent Received");
        System.out.println("----------------------------");
    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("----------------------------");
        System.out.println("ContextRefreshedEvent Received");
        System.out.println("----------------------------");
    }

    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("----------------------------");
        System.out.println("ContextClosedEvent Received");
        System.out.println("----------------------------");
    }
}