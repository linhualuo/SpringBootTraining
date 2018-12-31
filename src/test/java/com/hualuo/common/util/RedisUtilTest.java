package com.hualuo.common.util;

import com.hualuo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void get() {
//        assertEquals("hualuolin", (String)redisUtil.get("me"));
        System.out.println(redisUtil.get("me"));
    }

    @Test
    public void set() {
        User user = new User();
        user.setUserName("hualuo");
        user.setUserId("007");
        redisUtil.set("user", user);

        System.out.println(redisUtil.get("user"));
    }
}