package com.yonathandj.portal.controller;

import java.util.List;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import com.yonathandj.portal.constant.EndpointApp;
import com.yonathandj.portal.service.SkillCategoryService;
import com.yonathandj.portal.model.response.DefaultResponse;
import com.yonathandj.portal.model.request.SkillCategoryRequest;
import com.yonathandj.portal.model.response.SkillCategoryResponse;
import com.yonathandj.portal.validation.create.OnCreateSkillCategory;
import com.yonathandj.portal.validation.update.OnUpdateSkillCategory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = EndpointApp.SKILL_CATEGORY)
public class SkillCategoryController {
    private final SkillCategoryService skillCategoryService;

    @Validated(OnCreateSkillCategory.class)
    @PostMapping
    public ResponseEntity<?> createSkillCategory(@Valid @RequestBody SkillCategoryRequest skillCategoryRequest) {
        SkillCategoryResponse skillCategoryResponse = skillCategoryService.create(skillCategoryRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Skill category created successfully")
                        .data(skillCategoryResponse)
                        .build()
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSkillCategoryById(@PathVariable(name = "id") String id) {
        SkillCategoryResponse skillCategoryResponse = skillCategoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Skill category with id " + id +  " obtained successfully")
                        .data(skillCategoryResponse)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllSkillCategory() {
        List<SkillCategoryResponse> skillCategoryResponseList = skillCategoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("All skill category obtained successfully")
                        .data(skillCategoryResponseList)
                        .build()
        );
    }

    @Validated(OnUpdateSkillCategory.class)
    @PutMapping
    public ResponseEntity<?> updateSkillCategory(@Valid @RequestBody SkillCategoryRequest skillCategoryRequest) {
        SkillCategoryResponse skillCategoryResponse = skillCategoryService.update(skillCategoryRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Skill category updated successfully")
                        .data(skillCategoryResponse)
                        .build()
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSkillCategoryById(@PathVariable(name = "id") String id) {
        String skillCategoryResponse = skillCategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                DefaultResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Skill category deleted successfully")
                        .data(skillCategoryResponse)
                        .build()
        );
    }
}
