package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class HelloWorldMapper implements RowMapper<HelloWorld> {
    public HelloWorld mapRow(ResultSet rs, int rowNum) throws SQLException {
        HelloWorld world = new HelloWorld();
        world.setId(rs.getInt("id"));
        world.setMessage1(rs.getString("message1"));
        world.setMessage2(rs.getString("message2"));

        return world;
    }
}