package com.tutorialspoint;

import java.util.List;
import javax.sql.DataSource;

public interface HelloWorldDAO {
    /**
     * This is the method to be used to initialize database resources ie.
     * connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to createCodeTrans a record in the HelloWorld
     * table.
     */
    public void createCodeTrans(String message1, String message2);

    /**
     * This is the method to be used to createDeclTrans a record in the HelloWorld
     * table.
     */
    public void createDeclTrans(String message1, String message2);

    /**
     * This is the method to be used to list down a record from the HelloWorld table
     * corresponding to a passed object id.
     */
    public HelloWorld getHelloWorld(Integer id);

    /**
     * This is the method to be used to list down all the records from the
     * HelloWorld table.
     */
    public List<HelloWorld> listHelloWorlds();

    /**
     * This is the method to be used to delete a record from the HelloWorld table
     * corresponding to a passed object id.
     */
    public void delete(Integer id);

    /**
     * This is the method to be used to update a record into the HelloWorld table.
     */
    public void update(Integer id, String message1);
}