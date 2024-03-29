package com.oswizar.io.sample.threadlocal;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @date: 2019/5/14 14:01
 * @author: oswizar
 * @description:
 */

public class DBUtil {
    //数据库连接池
    private static BasicDataSource source;

    //为不同的线程管理连接
    private static ThreadLocal<Connection> local;


    static {
        try {
            //加载配置文件
            Properties properties = new Properties();

            //获取读取流
            InputStream stream = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");


            //从配置文件中读取数据
            properties.load(stream);

            //关闭流
            stream.close();

            //初始化连接池
            source = new BasicDataSource();

            //设置驱动
            source.setDriverClassName(properties.getProperty("driver"));

            //设置url
            source.setUrl(properties.getProperty("url"));

            //设置用户名
            source.setUsername(properties.getProperty("username"));

            //设置密码
            source.setPassword(properties.getProperty("password"));

            //初始化线程本地
            local = new ThreadLocal<>();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        if (local.get() != null) {
            return local.get();
        } else {

            //获取Connection对象
            Connection connection = source.getConnection();

            //把Connection放进ThreadLocal里面
            local.set(connection);

            //返回Connection对象
            return connection;
        }

    }

    //关闭数据库连接
    public static void closeConnection() {
        //从线程中拿到Connection对象
        Connection connection = local.get();

        try {
            if (connection != null) {
                //恢复连接为自动提交
                connection.setAutoCommit(true);

                //这里不是真的把连接关了,只是将该连接归还给连接池
                connection.close();

                //既然连接已经归还给连接池了,ThreadLocal保存的Connction对象也已经没用了
                local.remove();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(DBUtil.getConnection());

            System.out.println("未执行local.romove()之前");
            System.out.println(local.get());

            DBUtil.closeConnection();
            System.out.println(local.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
