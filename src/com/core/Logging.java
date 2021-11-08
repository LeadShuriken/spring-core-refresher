package com.core;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {

    static Logger log = Logger.getLogger(Logging.class.getName());

    /**
     * Following is the definition for a pointcut to select all the methods
     * available. So advice will be called for all the methods.
     */
    @Pointcut("execution(* com.core.HelloWorld.*(..))")
    private void selectAll() {
    }

    /**
     * This is the method which I would like to execute before a selected method
     * execution.
     */
    @Before("selectAll()")
    public void beforeAdvice() {
        log.info("Logging: Going to setup HelloWorld.");
    }

    /**
     * This is the method which I would like to execute after a selected method
     * execution.
     */
    @After("selectAll()")
    public void afterAdvice() {
        log.info("Logging: HelloWorld has been setup.");
    }

    /**
     * This is the method which I would like to execute when any method returns.
     */
    @AfterReturning(pointcut = "selectAll()", returning = "retVal")
    public void afterReturningAdvice(Object retVal) {
        log.info("Logging: HelloWorld saying " + retVal.toString());
    }

    /**
     * This is the method which I would like to execute if there is an exception
     * raised.
     */
    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        log.info("Logging: There has been an exception: " + ex.toString());
    }
}