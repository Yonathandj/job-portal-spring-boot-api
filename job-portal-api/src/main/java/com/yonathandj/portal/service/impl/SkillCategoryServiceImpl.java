package com.yonathandj.portal.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.yonathandj.portal.model.entity.SkillCategory;
import com.yonathandj.portal.service.SkillCategoryService;
import com.yonathandj.portal.repository.SkillCategoryRepository;
import com.yonathandj.portal.model.request.SkillCategoryRequest;
import com.yonathandj.portal.model.response.SkillCategoryResponse;

@Service
@RequiredArgsConstructor
public class SkillCategoryServiceImpl implements SkillCategoryService {
    private final SkillCategoryRepository skillCategoryRepository;

    @Override
    public SkillCategoryResponse create(SkillCategoryRequest skillCategoryRequest) {
        SkillCategory skillCategory = SkillCategory.builder()
                .name(skillCategoryRequest.getName().trim().toUpperCase())
                .build();

        skillCategoryRepository.save(skillCategory);
        return SkillCategoryResponse.builder()
                .id(skillCategory.getId())
                .name(skillCategory.getName())
                .build();
    }

    @Override
    public SkillCategoryResponse getById(String id) {
        SkillCategory skillCategory = skillCategoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Skill category with id " + id + " not found"));
        return SkillCategoryResponse.builder()
                .id(skillCategory.getId())
                .name(skillCategory.getName())
                .build();
    }

    @Override
    public List<SkillCategoryResponse> getAll() {
        List<SkillCategory> skillCategoryList = skillCategoryRepository.findAll();
        return skillCategoryList.stream().map(skillCategory -> {
            return SkillCategoryResponse.builder()
                    .id(skillCategory.getId())
                    .name(skillCategory.getName())
                    .build();
        }).toList();
    }

    @Override
    public SkillCategoryResponse update(SkillCategoryRequest skillCategoryRequest) {
        SkillCategory skillCategory = skillCategoryRepository.findById(skillCategoryRequest.getId()).orElseThrow(() -> new NoSuchElementException("Skill category with id " + skillCategoryRequest.getId() + " not found"));

        skillCategory.setName(skillCategoryRequest.getName().trim().toUpperCase());
        skillCategoryRepository.save(skillCategory);

        return SkillCategoryResponse.builder()
                .id(skillCategory.getId())
                .name(skillCategory.getName())
                .build();
    }

    @Override
    public String deleteById(String id) {
        boolean existingSkillCategory = skillCategoryRepository.existsById(id);
        if (!existingSkillCategory) {
            throw new NoSuchElementException("Skill category with id " + id + " not found");
        }
        skillCategoryRepository.deleteById(id);
        return "Skill category deleted successfully";
    }
}
