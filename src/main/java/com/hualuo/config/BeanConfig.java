package com.hualuo.config;

import com.hualuo.service.UserService;
import com.hualuo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joseph
 * @create 2018/10/20 0:20
 */
@Configuration
public class BeanConfig {

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
