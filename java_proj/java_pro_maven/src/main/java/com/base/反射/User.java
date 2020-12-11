package com.base.反射;
/**
 *
 * 把user.properties文件属性转为对象
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class User {
    private String name;
    private String pwd;
    private int age;

    public User() {
    }

    public User(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    private String path = User.class.getClassLoader().getResource("user.properties").getPath();

    /**
     *
     */
    public void load() throws IOException {
        Properties prop = new Properties();
        System.out.println(path);
        prop.load(new FileInputStream(path));
//        prop.load(User.class.getClassLoader().getResourceAsStream("user.properties")); //这种方式也可以读取资源文件

        parseObject(prop, this);  //this代表User对象，将prop的值读取存储为对象
    }

    /**
     * 该方法是把配置文件user.properties的信息读取出来，转为对象。 存储在User对象中
     */
    public void parseObject(Properties prop, Object obj) {
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
                String mn = method.getName();
                if (mn.startsWith("set")) {
                    String subName = mn.substring(4);
                    String subChar = mn.substring(3, 4);
                    String key = subChar.toLowerCase() + subName;
                    String value = prop.getProperty(key);
                    if (value != null) {
                        Class<?>[] paraTypes = method.getParameterTypes();
                        if (paraTypes != null && paraTypes.length > 0) {
                            String cm = paraTypes[0].getSimpleName();
                            Object arg = null;
                            if ("int".equals(cm)) {
                                arg = Integer.parseInt(value);
                            } else if ("long".equals(cm)) {
                                arg = Long.parseLong(cm);
                            } else if ("double".equals(cm)) {
                                arg = Double.parseDouble(value);
                            } else if ("boolean".equals(cm)) {
                                arg = Boolean.parseBoolean(value);
                            } else if ("String".equals(cm)) {
                                arg = value;
                            } else {
                                continue;
                            }
                            method.invoke(obj, arg);
                        }
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
