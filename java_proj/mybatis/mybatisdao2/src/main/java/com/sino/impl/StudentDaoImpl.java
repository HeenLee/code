package com.sino.impl;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.sino.dao.StudentDao.selectStudents";
        //执行sql语句，使用SqlSession类的方法
        List<Student> students = sqlSession.selectList(sqlId);

        //关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.sino.dao.StudentDao.insertStudent";
        //执行sql语句，使用SqlSession类的方法
        int num = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return num;
    }

}
