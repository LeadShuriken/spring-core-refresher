package com.tutorialspoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");

        // -------------------
        factory.start();
        System.out.println();

        HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();
        System.out.println();
        HelloIndia objB = (HelloIndia) factory.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
        System.out.println();

        TextEditor te = (TextEditor) factory.getBean("textEditor");
        te.spellCheck();

        System.out.println();
        JavaCollection jc = (JavaCollection) factory.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();

        jc.getAddressListBean();
        jc.getAddressSetBean();
        jc.getAddressMapBean();

        jc.getAddressProp();

        System.out.println();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(HelloWorldConfig.class);
        ctx.register(ContextEvent.class);
        ctx.register(CustomEventPublisher.class);
        ctx.register(CustomEventHandler.class);
        ctx.refresh();
        ctx.start();

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.setMessage1("Hello World From Java Config!");
        helloWorld.getMessage1();

        LittleHelper helper = ctx.getBean(LittleHelper.class);
        helper.sayHello();

        CustomEventPublisher cvp = (CustomEventPublisher) ctx.getBean(CustomEventPublisher.class);

        cvp.call();

        System.out.println();

        factory.stop();
        factory.registerShutdownHook();
        ctx.stop();
        ctx.registerShutdownHook();
        // -------------------
    }
}