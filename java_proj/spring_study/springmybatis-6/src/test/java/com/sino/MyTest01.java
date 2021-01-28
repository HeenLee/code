package com.sino;

import com.sino.dao.StudentDao;
import com.sino.domain.Student;
import com.sino.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest01 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 使用dao插入数据
     */
    @Test
    public void testDaoInsert(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao dao = (StudentDao) context.getBean("studentDao");
        Student student = new Student();
        student.setId(1013);
        student.setName("周二");
        student.setEmail("zhouer@qq.com");
        student.setAge(31);

        int num = dao.insertStudent(student);
        System.out.println(num);

    }

    /**
     * 使用service插入数据
     */
    @Test
    public void testServiceInsert(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的service对象
        StudentService studentService = (StudentService) context.getBean("studentService");
        Student student = new Student();
        student.setId(1014);
        student.setName("王其");
        student.setEmail("wangqi@qq.com");
        student.setAge(31);

        //spring和mybatis整合在一起使用，事务是自动提交的。无需执行SqlSession.commit()
        int num = studentService.addStudent(student);
        System.out.println(num);
    }

    /**
     * 使用service插入数据
     */
    @Test
    public void testServiceSelect(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的service对象
        StudentService studentService = (StudentService) context.getBean("studentService");

        //spring和mybatis整合在一起使用，事务是自动提交的。无需执行SqlSession.commit()
        List<Student> students = studentService.queryStudents();
        System.out.println(students);
    }
}
