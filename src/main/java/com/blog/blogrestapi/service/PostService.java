package com.blog.blogrestapi.service;

import com.blog.blogrestapi.data.dto.PostDto;
import com.blog.blogrestapi.data.dto.PostResponse;

public interface PostService {

    PostDto createPost(PostDto dto);

    PostResponse getAllPosts(Integer pageNo, Integer pageSize, String sortBy, String sortDir);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto dto, Long id);

    void deletePostById(Long id);

}
