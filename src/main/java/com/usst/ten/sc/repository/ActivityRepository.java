package com.usst.ten.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.ten.sc.entity.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByTag(String tag);
}
