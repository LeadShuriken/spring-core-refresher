package com.core;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

public class InitHelloWorld implements BeanPostProcessor {

    static Logger log = Logger.getLogger(InitHelloWorld.class.getName());

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeforeInitialization : " + beanName);
        return bean; // you can return any other object as well
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("AfterInitialization : " + beanName);
        return bean; // you can return any other object as well
    }
}