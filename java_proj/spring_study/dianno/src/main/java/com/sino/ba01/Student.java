package com.sino.ba01;

import org.springframework.stereotype.Component;

/**
 * @Component 创建对象的，等同于<bean>的功能
 *          属性：value  就是对象的名称，也就是bean的id值
 *               value的值是唯一的，创建的对象在整个spring容器中就一个
 *           位置：在类的上面
 *      @Component(value="myStudent")等同于
 *        <bean id="myStudent" class="com.sino.ba01.Student" />
 *
 *        spring中和@Component功能一致，创建对象的注解还有：
 *         1.@Repository（持久层类的上面注解），放在dao的实现类上面，表示创建dao对象，dao对象是能访问数据库的
 *         2.@Service(用在业务层类的上面)：放在service的实现类上面，创建service对象，
 *              service对象是做业务处理，可以有事务等功能的
 *          3.@Controller（用在控制器的上面）：放在控制器（处理器）类的上面，
 *             创建控制器对象的，控制器对象，能够接受用户提交的参数，显示请求的处理结果
 *         以上三个注解的使用语法和@Component是一样的。都能创建对象。但是这三个注解还有额外的功能
 *         @Repository  @Service   @Controller是给项目的对象分层的
 */
//1.使用value属性，指定对象名称  注解中，只有value属性的话，value可以省略
//@Component(value="myStudent")
 //2. 省略value  常用
@Component("myStudent1")

//3. 不指定对象名称，由spring提供默认名称
//@Component

public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("Student无参构造");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
