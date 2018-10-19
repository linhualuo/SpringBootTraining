package com.hualuo.controller;

import com.hualuo.model.User;
import com.hualuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Joseph
 * @create 2018/10/20 0:24
 */
@RestController
public class FrontEndController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> queryAllUsers() throws Exception {
        return userService.queryAllUsers();
    }
}
