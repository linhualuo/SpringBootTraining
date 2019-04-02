package com.hualuo.service;

import com.hualuo.model.entity.User;

import java.util.List;

/**
 * @author Joseph
 * @create 2018/10/20 0:19
 */
public interface UserService {
    List<User> queryAllUsers() throws Exception;
}
