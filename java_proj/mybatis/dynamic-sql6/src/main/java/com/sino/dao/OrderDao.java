package com.sino.dao;

import com.sino.domain.Student;

import java.util.List;

//接口操作Student表
public interface OrderDao {
    //if使用
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);


    //foreach用法1
    List<Student> selectForeachOne(List<Integer> idList);

    //foreach用法2
    List<Student> selectForeachTwo(List<Student> stuList);

}
