package com.yonathandj.portal.service;

import java.util.List;

import com.yonathandj.portal.model.request.JobCategoryRequest;
import com.yonathandj.portal.model.response.JobCategoryResponse;

public interface JobCategoryService {
    JobCategoryResponse create(JobCategoryRequest jobCategoryRequest);
    JobCategoryResponse getById(String id);
    List<JobCategoryResponse> getAll();
    JobCategoryResponse update(JobCategoryRequest jobCategoryRequest);
    String deleteById(String id);
}
