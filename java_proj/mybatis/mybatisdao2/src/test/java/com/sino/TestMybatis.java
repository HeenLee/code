package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.impl.StudentDaoImpl;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        /**
         *
         */
        List<Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1005);
        student.setName("关于");
        student.setEmail("guanyu@sina.com");
        student.setAge(23);

        int num = dao.insertStudent(student);
        System.out.println(num);
    }
}
