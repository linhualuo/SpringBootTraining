package com.hualuo.dao;

import com.hualuo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joseph
 * @create 2018/10/20 0:21
 */
public interface UserDao extends JpaRepository<User, String> {
}
