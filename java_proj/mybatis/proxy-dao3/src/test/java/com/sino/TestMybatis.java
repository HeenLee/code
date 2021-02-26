package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        /**
         * 使用mybatis动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1006);
        student.setName("诸葛亮");
        student.setEmail("zhugeliang@sina.com");
        student.setAge(28);

        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(num);
    }
}
