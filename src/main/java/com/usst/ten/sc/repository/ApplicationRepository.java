package com.usst.ten.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.ten.sc.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application deleteByUidAndTag(String uid, String tag);
    Application findByTag(String tag);
}
