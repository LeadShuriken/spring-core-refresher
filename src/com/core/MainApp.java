package com.core;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.core.dao.HelloWorldDAO;
import com.core.events.ContextEvent;
import com.core.events.CustomEventHandler;
import com.core.events.CustomEventPublisher;
import com.core.pojo.HelloIndia;
import com.core.pojo.HelloWorld;
import com.core.pojo.JavaCollection;
import com.core.pojo.LittleHelper;
import com.core.pojo.TextEditor;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    static Logger log = Logger.getLogger(MainApp.class.getName());

    private static void execute(Connection conn, String st) {
        try (Statement statement = conn.createStatement();) {
            statement.execute(st);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private static void testJDBC(AbstractApplicationContext factory) {
        HelloWorldDAO helloWorldJDBCTemplate = (HelloWorldDAO) factory.getBean("helloWorldJDBCTemplate");

        try (Connection conn = helloWorldJDBCTemplate.getDataSource().getConnection()) {
            execute(conn, "DROP TABLE IF EXISTS HelloWorld");

            execute(conn,
                    "CREATE TABLE HelloWorld(ID INT NOT NULL AUTO_INCREMENT, MESSAGE1 VARCHAR(20), MESSAGE2 VARCHAR(20), PRIMARY KEY (ID))");

            execute(conn, "DROP PROCEDURE IF EXISTS getRecord");

            execute(conn,
                    "CREATE PROCEDURE getRecord (\n" + "IN in_id INTEGER,\n" + " OUT out_message1 VARCHAR(20))\n"
                            + "BEGIN\n" + " SELECT message1\n" + " INTO out_message1\n"
                            + " FROM HelloWorld where id = in_id;\n" + " END\n");

            log.info("------Records Creation--------");
            helloWorldJDBCTemplate.createCodeTrans("A", "B");
            helloWorldJDBCTemplate.createDeclTrans("C", "D");

            log.info("------Listing Multiple Records--------");
            List<HelloWorld> worlds = helloWorldJDBCTemplate.listHelloWorlds();

            for (HelloWorld record : worlds) {
                log.info(record);
            }

            log.info("----Updating Record with ID = 2 -----");
            helloWorldJDBCTemplate.update(2, "CHANGED");

            log.info("----Listing Record with ID = 2 -----");
            log.info(helloWorldJDBCTemplate.getHelloWorld(2));
        } catch (Exception e) {
            log.error(e.getMessage());
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {

        AbstractApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        // -------------------
        // NEED a MYSQL server running on 3306 with TEST db init
        // testJDBC(factory);
        // -------------------

        factory.start();
        HelloWorld objA = (HelloWorld) factory.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();
        try {
            objA.printThrowException();
        } catch (Exception e) {
        }

        //
        HelloIndia objB = (HelloIndia) factory.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();

        TextEditor te = (TextEditor) factory.getBean("textEditor");
        te.spellCheck();

        JavaCollection jc = (JavaCollection) factory.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();

        jc.getAddressListBean();
        jc.getAddressSetBean();
        jc.getAddressMapBean();

        jc.getAddressProp();

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

        factory.stop();
        factory.registerShutdownHook();
        ctx.stop();
        ctx.registerShutdownHook();
        // -------------------
    }
}