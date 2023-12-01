package com.oswizar.io.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
            System.out.println(forName);
            Class<?> t = Class.forName("java.lang.Thread");
            System.out.println(t);
            long n = 2147483647;
            System.out.println(n + 1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
