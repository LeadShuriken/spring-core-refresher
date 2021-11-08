package com.core;

import com.core.pojo.HelloWorld;

import org.springframework.context.annotation.*;

@Import(LittleHelperConfig.class)
public class HelloWorldConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}