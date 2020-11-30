package com.base.jdbc数据库;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询表，封装成对象，装在集合，打印
 * 1.定义一个类
 * 2.定义一个方法 putlic List<Demo03Emp>  findAll()
 * 3.实现方法 select * from emp;  executeEQuery()
 */
public class Demo03_JDBC_Select {
    public static void main(String[] args) {
        List<Demo03Emp> list = new Demo03_JDBC_Select().finaAll();
        System.out.println(list);
    }

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Demo03Emp> finaAll() {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Demo03Emp> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc数据库:mysql://localhost:3306/student?serverTimezone=UTC", "root", "root");
            //3.获取执行sql对象
            stmt = conn.createStatement();
            //4.定义sql
            String sql = "select * from stu";
            //5.执行sql
            rs = stmt.executeQuery(sql);
            Demo03Emp demo03Emp = null;
            list = new ArrayList<Demo03Emp>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bouns = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                demo03Emp = new Demo03Emp();
                demo03Emp.setId(id);
                demo03Emp.setEname(ename);
                demo03Emp.setJob_id(job_id);
                demo03Emp.setMgr(mgr);
                demo03Emp.setJoindate(joindate);
                demo03Emp.setSalary(salary);
                demo03Emp.setBonus(bouns);
                demo03Emp.setDept_id(dept_id);
                list.add(demo03Emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }
}
