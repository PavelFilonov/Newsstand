package com.ru.vsu.csf.group7.filonov.db.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static ConnectionManager instance;

    private ConnectionManager() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find db driver: " + e.getMessage());
        }
    }

    static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    Connection getConnection() throws SQLException  {
        Properties p = new Properties();

        InputStream in = ConnectionManager.class.getResourceAsStream("/db.properties");
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String password = p.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }
}
