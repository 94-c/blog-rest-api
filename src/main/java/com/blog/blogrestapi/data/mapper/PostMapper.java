package com.blog.blogrestapi.data.mapper;

import com.blog.blogrestapi.data.dto.PostDto;
import com.blog.blogrestapi.data.entity.Post;

public class PostMapper {
    public static PostDto entityToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setBody(post.getBody());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        return postDto;
    }
}
