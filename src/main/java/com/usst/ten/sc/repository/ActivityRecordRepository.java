package com.usst.ten.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.ten.sc.entity.ActivityRecord;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Integer> {

}
