package com.yonathandj.portal.model.request;

import lombok.*;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import com.yonathandj.portal.validation.create.OnCreateSkillCategory;
import com.yonathandj.portal.validation.update.OnUpdateSkillCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SkillCategoryRequest {
    @Null(groups = OnCreateSkillCategory.class)
    @NotNull(message = "Skill category id cannot be null", groups = OnUpdateSkillCategory.class)
    @NotBlank(message = "Skill category id cannot be blank", groups = OnUpdateSkillCategory.class)
    private String id;

    @NotNull(message = "Skill category name cannot be null", groups = {OnCreateSkillCategory.class, OnUpdateSkillCategory.class})
    @NotBlank(message = "Skill category name cannot be blank", groups = {OnCreateSkillCategory.class, OnUpdateSkillCategory.class})
    private String name;
}
