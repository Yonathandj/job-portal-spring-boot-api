package com.yonathandj.portal.model.request;

import lombok.*;

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import com.yonathandj.portal.validation.create.OnCreateJobCategory;
import com.yonathandj.portal.validation.update.OnUpdateJobCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class JobCategoryRequest {
    @Null(groups = OnCreateJobCategory.class)
    @NotNull(message = "Job category id cannot be null", groups = OnUpdateJobCategory.class)
    @NotBlank(message = "Job category id cannot be blank", groups = OnUpdateJobCategory.class)
    private String id;

    @NotNull(message = "Job category name cannot be null")
    @NotBlank(message = "Job category name cannot be blank")
    private String name;
}

