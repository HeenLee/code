package com.hollysys.test.base.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库工具类
 */
public class JDBCUtils {
   /**
    * 数据库访问地址
    */
	private static String URL;
	
	/**
	 * 数据库用户名
	 */
    private static String USER;
    
	/**
	 * 数据库密码
	 */
    private static String PASSWORD;
    
	/**
	 * 数据库驱动
	 */
    private static String DRIVER;
    
	/**
	 * 数据库配置文件
	 */
	private static String DB_PATH = System.getProperty("user.dir") + File.separator + "config" + File.separator + "database.properties";
    
    /**
     * 文件的读取，只需要读取一次即可拿到配置文件的值
     */
    static{
        //读取资源文件，获取值
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(DB_PATH));
            URL = pro.getProperty("url");
            USER = pro.getProperty("user");
            PASSWORD = pro.getProperty("password");
            DRIVER = pro.getProperty("driver");

            Class.forName(DRIVER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 获取连接
     * @return  连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
