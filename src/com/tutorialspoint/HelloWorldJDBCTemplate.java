package com.tutorialspoint;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class HelloWorldJDBCTemplate implements HelloWorldDAO {
    private JdbcTemplate jdbcTemplateObject;
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private PlatformTransactionManager transactionManager;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void createCodeTrans(String message1, String message2) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String SQL = "insert into HelloWorld (message1, message2) values (?, ?)";
            jdbcTemplateObject.update(SQL, message1, message2);
            // throw new RuntimeException("simulate Error condition");
            System.out.println("Created Record Message1 = " + message1 + " Message2 = " + message2);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void createDeclTrans(String message1, String message2) {
        try {
            String SQL = "insert into HelloWorld (message1, message2) values (?, ?)";
            jdbcTemplateObject.update(SQL, message1, message2);

            // throw new RuntimeException("simulate Error condition");
            System.out.println("Created Record Message1 = " + message1 + " Message2 = " + message2);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            throw e;
        }
    }

    public HelloWorld getHelloWorld(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);

        HelloWorld record = new HelloWorld();
        record.setId(id);
        record.setMessage1((String) out.get("out_message1"));
        record.setMessage2("chill");
        return record;
    }

    public List<HelloWorld> listHelloWorlds() {
        String SQL = "select * from HelloWorld";
        List<HelloWorld> objects = jdbcTemplateObject.query(SQL, new HelloWorldMapper());
        return objects;
    }

    public void delete(Integer id) {
        String SQL = "delete from HelloWorld where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    public void update(Integer id, String message1) {
        String SQL = "update HelloWorld set message1 = ? where id = ?";
        jdbcTemplateObject.update(SQL, message1, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}
