package com.yonathandj.portal.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import com.yonathandj.portal.constant.EndpointApp;
import com.yonathandj.portal.service.JobCategoryService;
import com.yonathandj.portal.model.response.DefaultResponse;
import com.yonathandj.portal.model.request.JobCategoryRequest;
import com.yonathandj.portal.model.response.JobCategoryResponse;
import com.yonathandj.portal.validation.create.OnCreateJobCategory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = EndpointApp.JOB_CATEGORY)
public class JobCategoryController {
    private final JobCategoryService jobCategoryService;

    @Validated(OnCreateJobCategory.class)
    @PostMapping
    public ResponseEntity<?> createJobCategory(@Valid @RequestBody JobCategoryRequest jobCategoryRequest) {
        JobCategoryResponse jobCategoryResponse = jobCategoryService.create(jobCategoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Job category created successfully")
                        .data(jobCategoryResponse)
                        .build()
        );
    }
}
