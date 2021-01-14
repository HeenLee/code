package com.sino.dao.impl;

import com.sino.dao.UserDao;
import com.sino.domain.SysUser;

public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("user插入到mysql数据库");
    }
}
