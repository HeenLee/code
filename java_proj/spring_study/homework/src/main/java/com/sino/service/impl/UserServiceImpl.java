package com.sino.service.impl;
/**
 * 调用逻辑是：
 * 1. 首先有一个user用户--domain
 * 2. 然后业务逻辑处理添加用户addUser -- Service  service调用dao数据库。
 *      所以需要在类中定义操作数据库的对象
 * 3. 数据库dao完成插入数据的操作
 *
 */

import com.sino.dao.UserDao;
import com.sino.domain.SysUser;
import com.sino.service.UserService;

public class UserServiceImpl implements UserService {

    //引用类型，在xml文件给属性赋值，要求属性需要有set方法
    private UserDao dao = null;

    /**
     * 只要有set方法就能给dao进行赋值  不需要其他的属性变量
     * @param dao
     */
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        dao.insertUser(user);
    }
}
