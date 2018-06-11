package com.usst.ten.sc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usst.ten.sc.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {
}
