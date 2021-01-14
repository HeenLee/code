package com.sino;

import com.sino.domain.SysUser;
import com.sino.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        //从spring容器中获取UserService类型的对象，dao,service都是spring管理的
        //1. 获取spring容器对象ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) context.getBean("userservice");

        //定义实体对象
        SysUser user = new SysUser();
        user.setAge(23);
        user.setName("张三");

        service.addUser(user);

    }
}
