package com.usst.ten.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.ten.sc.entity.User;


//用户操作类，用于连接数据库中相应的用户表，并实现相应的数据操作
public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String phoneNumber);
}
