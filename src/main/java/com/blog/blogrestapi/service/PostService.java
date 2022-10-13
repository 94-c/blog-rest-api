package com.blog.blogrestapi.service;

import com.blog.blogrestapi.data.dto.PostDto;
import com.blog.blogrestapi.data.dto.request.CreatePostRequestDto;
import com.blog.blogrestapi.data.entity.Post;
import com.blog.blogrestapi.data.repository.PostRepository;

import java.util.List;

public interface PostService {
    List<PostDto> getPosts();

    PostDto createPost(CreatePostRequestDto dto);

}
