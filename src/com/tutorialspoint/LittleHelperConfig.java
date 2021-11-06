package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LittleHelperConfig {

    @Bean
    @Scope("prototype")
    public LittleHelper a() {
        return new LittleHelper();
    }
}
