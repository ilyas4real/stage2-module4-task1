package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection c = null;
        try {
            Properties properties = new Properties();
            properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
            String jdbcDriver = properties.getProperty("jdbc_driver");
            String dbUrl = properties.getProperty("db_url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(jdbcDriver);
            c = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return c;
    }
}

