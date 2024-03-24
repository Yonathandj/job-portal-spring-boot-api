package com.yonathandj.portal.repository;

import com.yonathandj.portal.model.entity.SkillCategory;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, String> {
}
