package com.yonathandj.portal.repository;

import com.yonathandj.portal.model.entity.JobCategory;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, String> {
}
