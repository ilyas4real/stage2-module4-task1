package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private Properties properties;

    public H2ConnectionFactory(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Connection createConnection() throws SQLException {
        String jdbcDriver = properties.getProperty("jdbc_driver");
        String dbUrl = properties.getProperty("db_url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver", e);
        }

        return DriverManager.getConnection(dbUrl, user, password);
    }
}

