package com.metlife.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class MysqlConnection {
    static Logger log = Logger.getLogger(MysqlConnection.class.toString());


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Admin@123");
        } catch (ClassNotFoundException e) {
            log.info("Exception Occurred while register the driver..!!" + e.getMessage());

        } catch (Exception e) {
            log.info("Exception Occurred while established the connection..!!" + e.getMessage());
        }
        return connection;
    }
}
