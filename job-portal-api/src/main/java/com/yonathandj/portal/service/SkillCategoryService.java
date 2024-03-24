package com.yonathandj.portal.service;

import java.util.List;

import com.yonathandj.portal.model.request.SkillCategoryRequest;
import com.yonathandj.portal.model.response.SkillCategoryResponse;

public interface SkillCategoryService {
    SkillCategoryResponse create(SkillCategoryRequest skillCategoryRequest);
    SkillCategoryResponse getById(String id);
    List<SkillCategoryResponse> getAll();
    SkillCategoryResponse update(SkillCategoryRequest skillCategoryRequest);
    String deleteById(String id);
}
