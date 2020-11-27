package com.base.jdbc;


import java.sql.*;

/**
 * 数据库操作
 * 添加
 * 删除
 * 修改
 * 查询
 */
public class Demo02_JDBC_Select {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "select * from st";
            conn = DriverManager.getConnection("jdbc:mysql:///student?serverTimezone=UTC", "root", "root");
            stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(sql);

            //让游标向下一行
            while(set.next()){
                int id =  set.getInt(1);
                String name = set.getString("name");
                System.out.println(id + "---" + name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
