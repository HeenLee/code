package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudentIf() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(15);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students) {
            System.out.println(stu);

        }
    }

    @Test
    public void testSelectStudentWhere() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(15);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students) {
            System.out.println(stu);

        }
    }



}
