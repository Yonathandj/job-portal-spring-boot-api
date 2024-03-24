package com.yonathandj.portal.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SkillCategoryResponse {
    private String id;
    private String name;
}
