package com.yonathandj.portal.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DefaultResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
