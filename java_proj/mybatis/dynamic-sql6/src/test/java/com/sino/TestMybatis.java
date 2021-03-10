package com.sino;

import com.github.pagehelper.PageHelper;
import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testSelectForOne() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectForTwo() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stuList = new ArrayList<>();

        Student stu1 = new Student();
        stu1.setId(1002);

        Student stu2 = new Student();
        stu2.setId(1003);

        stuList.add(stu1);
        stuList.add(stu2);

        List<Student> students = dao.selectForeachTwo(stuList);
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectAllPageHelper() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页
        //pageNum：第几页，从1开始
        //pageSize:一页中有多少行数据
        PageHelper.startPage(2, 3);
        List<Student> students = dao.selectAll();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

}
