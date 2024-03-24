package com.yonathandj.portal.controller;

import com.yonathandj.portal.validation.update.OnUpdateJobCategory;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getJobCategoryById(@PathVariable(name = "id") String id) {
        JobCategoryResponse jobCategoryResponse = jobCategoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Job category with id " + id +  " obtained successfully")
                        .data(jobCategoryResponse)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllJobCategory() {
        List<JobCategoryResponse> jobCategoryResponseList = jobCategoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("All job category obtained successfully")
                        .data(jobCategoryResponseList)
                        .build()
        );
    }

    @Validated(OnUpdateJobCategory.class)
    @PutMapping
    public ResponseEntity<?> updateJobCategory(@Valid @RequestBody JobCategoryRequest jobCategoryRequest) {
        JobCategoryResponse jobCategoryResponse = jobCategoryService.update(jobCategoryRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Job category updated successfully")
                        .data(jobCategoryResponse)
                        .build()
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteJobCategoryById(@PathVariable(name = "id") String id) {
        String jobCategoryResponse = jobCategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Job category deleted successfully")
                        .data(jobCategoryResponse)
                        .build()
        );
    }
}
