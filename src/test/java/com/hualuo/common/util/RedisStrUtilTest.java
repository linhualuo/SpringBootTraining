package com.hualuo.common.util;

import com.alibaba.fastjson.JSON;
import com.hualuo.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStrUtilTest {

    @Autowired
    private RedisStrUtil redisUtil;

    @Test
    public void get() {
        System.out.println(redisUtil.get("user"));
    }

    @Test
    public void set() {
        User user = new User();
        user.setUserName("hualuo");
        user.setUserId("007");
        redisUtil.set("user1", JSON.toJSONString(user));

        System.out.println(redisUtil.get("user1"));
    }
}