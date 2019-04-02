package com.hualuo.service;

import com.alibaba.fastjson.JSON;
import com.hualuo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderQueryServiceTest extends BaseTest {

    @Autowired
    private OrderQueryService orderQueryService;

    @Test
    public void queryByOrderId() {
        System.out.println(JSON.toJSONString(orderQueryService.queryByOrderId("CS20181201ggg")));
    }

    @Test
    public void query2() {
        orderQueryService.queryPackageByOrderId("CS20181201ggg");
    }
}