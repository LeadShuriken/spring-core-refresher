package com.core.events;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

@Configuration
public class ContextEvent implements ApplicationListener<ContextClosedEvent> {
    static Logger log = Logger.getLogger(ContextEvent.class.getName());

    public void onApplicationEvent(ContextStartedEvent event) {
        log.info("ContextStartedEvent Received");
    }

    public void onApplicationEvent(ContextStoppedEvent event) {
        log.info("ContextStoppedEvent Received");
    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent Received");
    }

    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("ContextClosedEvent Received");
    }
}