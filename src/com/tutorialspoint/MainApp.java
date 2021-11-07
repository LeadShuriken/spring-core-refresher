package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    private static void execute(Connection conn, String st) {
        try (Statement statement = conn.createStatement();) {
            statement.execute(st);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST", "root", "")) {
            execute(conn, "DROP TABLE IF EXISTS HelloWorld");

            execute(conn,
                    "CREATE TABLE HelloWorld(ID INT NOT NULL AUTO_INCREMENT, MESSAGE1 VARCHAR(20), MESSAGE2 VARCHAR(20), PRIMARY KEY (ID))");

            execute(conn, "DROP PROCEDURE IF EXISTS getRecord");

            execute(conn,
                    "CREATE PROCEDURE getRecord (\n" + "IN in_id INTEGER,\n" + " OUT out_message1 VARCHAR(20))\n"
                            + "BEGIN\n" + " SELECT message1\n" + " INTO out_message1\n"
                            + " FROM HelloWorld where id = in_id;\n" + " END\n");

            HelloWorldDAO helloWorldJDBCTemplate = (HelloWorldDAO) factory.getBean("helloWorldJDBCTemplate");

            System.out.println("------Records Creation--------");
            helloWorldJDBCTemplate.createCodeTrans("A", "B");
            helloWorldJDBCTemplate.createDeclTrans("C", "D");

            System.out.println("------Listing Multiple Records--------");
            List<HelloWorld> worlds = helloWorldJDBCTemplate.listHelloWorlds();

            for (HelloWorld record : worlds) {
                System.out.println(record);
            }

            System.out.println("----Updating Record with ID = 2 -----");
            helloWorldJDBCTemplate.update(2, "CHANGED");

            System.out.println("----Listing Record with ID = 2 -----");
            System.out.println(helloWorldJDBCTemplate.getHelloWorld(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }

        // -------------------
        // factory.start();
        // System.out.println();

        // HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
        // objA.getMessage1();
        // objA.getMessage2();
        // try {
        // objA.printThrowException();
        // } catch (Exception e) {
        // System.out.println();
        // }

        // //
        // HelloIndia objB = (HelloIndia) factory.getBean("helloIndia");
        // objB.getMessage1();
        // objB.getMessage2();
        // objB.getMessage3();
        // System.out.println();

        // TextEditor te = (TextEditor) factory.getBean("textEditor");
        // te.spellCheck();

        // System.out.println();
        // JavaCollection jc = (JavaCollection) factory.getBean("javaCollection");

        // jc.getAddressList();
        // jc.getAddressSet();
        // jc.getAddressMap();

        // jc.getAddressListBean();
        // jc.getAddressSetBean();
        // jc.getAddressMapBean();

        // jc.getAddressProp();

        // System.out.println();

        // AnnotationConfigApplicationContext ctx = new
        // AnnotationConfigApplicationContext();

        // ctx.register(HelloWorldConfig.class);
        // ctx.register(ContextEvent.class);
        // ctx.register(CustomEventPublisher.class);
        // ctx.register(CustomEventHandler.class);
        // ctx.refresh();
        // ctx.start();

        // HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        // helloWorld.setMessage1("Hello World From Java Config!");
        // helloWorld.getMessage1();

        // LittleHelper helper = ctx.getBean(LittleHelper.class);
        // helper.sayHello();

        // CustomEventPublisher cvp = (CustomEventPublisher)
        // ctx.getBean(CustomEventPublisher.class);

        // cvp.call();

        // System.out.println();

        // factory.stop();
        // factory.registerShutdownHook();
        // ctx.stop();
        // ctx.registerShutdownHook();
        // // -------------------
    }
}