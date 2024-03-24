package com.yonathandj.portal.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import com.yonathandj.portal.model.entity.JobCategory;
import com.yonathandj.portal.service.JobCategoryService;
import com.yonathandj.portal.repository.JobCategoryRepository;
import com.yonathandj.portal.model.request.JobCategoryRequest;
import com.yonathandj.portal.model.response.JobCategoryResponse;

@Service
@RequiredArgsConstructor
public class JobCategoryServiceImpl implements JobCategoryService {
    private final JobCategoryRepository jobCategoryRepository;

    @Override
    public JobCategoryResponse create(JobCategoryRequest jobCategoryRequest) {
        JobCategory jobCategory = JobCategory.builder()
                .name(jobCategoryRequest.getName().trim().toUpperCase())
                .build();
        jobCategoryRepository.save(jobCategory);
        return JobCategoryResponse.builder()
                .id(jobCategory.getId())
                .name(jobCategory.getName())
                .build();
    }

    @Override
    public JobCategoryResponse getById(String id) {
        JobCategory jobCategory = jobCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Job category with id " + id + " not found"));

        return JobCategoryResponse.builder()
                .id(jobCategory.getId())
                .name(jobCategory.getName())
                .build();
    }

    @Override
    public List<JobCategoryResponse> getAll() {
        List<JobCategory> jobCategoryList = jobCategoryRepository.findAll();
        return jobCategoryList.stream().map(jobCategory -> {
            return JobCategoryResponse.builder()
                    .id(jobCategory.getId())
                    .name(jobCategory.getName())
                    .build();
        }).toList();
    }

    @Override
    public JobCategoryResponse update(JobCategoryRequest jobCategoryRequest) {
        JobCategory jobCategory = jobCategoryRepository.findById(jobCategoryRequest.getId()).orElseThrow(() -> new NoSuchElementException("Job category with id " + jobCategoryRequest.getId() + " not found"));

        jobCategory.setName(jobCategoryRequest.getName().trim().toUpperCase());
        jobCategoryRepository.save(jobCategory);

        return JobCategoryResponse.builder()
                .id(jobCategory.getId())
                .name(jobCategory.getName())
                .build();
    }

    @Override
    public String deleteById(String id) {
        boolean existingJobCategory = jobCategoryRepository.existsById(id);
        if (!existingJobCategory) {
            throw new NoSuchElementException("Job category with id " + id + " not found");
        }
        jobCategoryRepository.deleteById(id);
        return "Job category deleted successfully";
    }
}
