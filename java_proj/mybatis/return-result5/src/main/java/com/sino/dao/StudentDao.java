package com.sino.dao;

import com.sino.domain.MyStudent;
import com.sino.domain.Student;
import com.sino.vo.QueryParam;
import com.sino.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//接口操作Student表
public interface StudentDao {

    public Student selectStudentById(@Param("studentId") Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage")  Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object, Object> selectMapById(@Param("stuid") Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    /*第一种模糊查询，在java代码中指定like的内容*/
    List<Student> selectLikeOne(String name);

    /*
      name就是李值，在mapper中拼接like "%李%“
     */
    List<Student> selectLikeTwo(String name);


}
