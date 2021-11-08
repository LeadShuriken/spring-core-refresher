package com.core.events;

import java.util.logging.Logger;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    static Logger log = Logger.getLogger(CustomEventHandler.class.getName());

    public void onApplicationEvent(CustomEvent event) {
        log.info(event.toString());
    }
}