package com.sino.service.impl;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //引用类型
    private StudentDao studentDao;
    //使用set注入，赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {

       return studentDao.selectStudents();
    }
}
