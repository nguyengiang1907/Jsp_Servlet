package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    String hostName = "localhost:3306";
    String dbName = "Student_Jdbc";
    String userName = "root";
    String password = "giang";

    String connectUrl = "jdbc:mysql://"+hostName+"/"+dbName;

    public Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(connectUrl,userName,password);
        return connection;
    }
}
