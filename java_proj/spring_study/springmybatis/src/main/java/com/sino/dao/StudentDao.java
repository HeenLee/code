package com.sino.dao;

import com.sino.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudents();
}
