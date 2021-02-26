package com.sino.dao;

import com.sino.domain.Student;

import java.util.List;

//接口操作Student表
public interface StudentDao {
    //查询student表中的所有数据
    List<Student> selectStudents();

    int insertStudent(Student student);
}
