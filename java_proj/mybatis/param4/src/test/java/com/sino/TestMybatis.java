package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库的操作
        Student student = dao.selectStudentById(1002);
        System.out.println(student);

    }

}
