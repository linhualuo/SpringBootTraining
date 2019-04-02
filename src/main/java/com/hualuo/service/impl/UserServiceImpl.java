package com.hualuo.service.impl;

import com.hualuo.dao.UserDao;
import com.hualuo.model.entity.User;
import com.hualuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Joseph
 * @create 2018/10/20 0:20
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAllUsers() throws Exception {
        return userDao.findAll();
    }
}
