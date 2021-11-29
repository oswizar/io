package com.oswizar.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
