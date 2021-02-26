package com.sino;
//使用封装的utils工具类获取SqlSession对象
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        //1.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.指定要执行的sql语句的标识。sql映射文件中namespace + "." + 标签的id值
        String sqlId = "com.sino.dao.StudentDao" + "." + "selectStudents";

        //3.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);

        //4.输出结果
        for (Student student : studentList) {
            System.out.println(student);
        }

        //5.关闭SqlSeesion对象
        sqlSession.close();

    }
}
