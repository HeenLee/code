package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.MyStudent;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import com.sino.vo.QueryParam;
import com.sino.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    @Test
    public void testSelectStudentById() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库的操作
        Student student = dao.selectStudentById(1002);
        System.out.println(student);

    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四", 20);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectReturnViewStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentReturnViewStudent(1001);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testCountStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int num = dao.countStudent();
        System.out.println(num);
        sqlSession.close();
    }

    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMyStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent();
        for (MyStudent student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDiffColProperty() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDiffColProperty();
        for (MyStudent student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备like的内容
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备like的内容
        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
