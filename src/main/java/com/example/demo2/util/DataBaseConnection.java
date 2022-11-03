package com.example.demo2.util;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataBaseConnection {

    public DataSource getDatasource(){

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://localhost/jideofo?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("emmanuel");


        return dataSource;

    }

    public boolean isConnectionValid(){

        try(Connection connection = getDatasource().getConnection()){

            return connection.isValid(0);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }
}
