package com.blog.blogrestapi.data.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePostRequestDto {
    private String title;
    private String body;
}
