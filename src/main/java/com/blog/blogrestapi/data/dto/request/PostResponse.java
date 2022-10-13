package com.blog.blogrestapi.data.dto.request;

import com.blog.blogrestapi.data.dto.PostDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PostResponse {

    private List<PostDto> postDtoList;
}
