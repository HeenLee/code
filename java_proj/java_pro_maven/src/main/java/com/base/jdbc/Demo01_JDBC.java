package com.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据路的步骤
 */
public class Demo01_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.引入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=UTC","root","root");
        //4.定义sql语句
        String sql = "update st set name = '小李' where id = 6";

        //5.获取执行sql的对象statement
        Statement stmet = conn.createStatement();
        //6.执行sql
        int count = stmet.executeUpdate(sql);
        //7.获取结果
        System.out.println(count);

        //8.释放资源
        stmet.close();
        conn.close();

    }
}
