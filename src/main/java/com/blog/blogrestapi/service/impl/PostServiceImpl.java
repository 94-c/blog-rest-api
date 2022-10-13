package com.blog.blogrestapi.service.impl;

import com.blog.blogrestapi.data.dto.PostDto;
import com.blog.blogrestapi.data.dto.request.CreatePostRequestDto;
import com.blog.blogrestapi.data.entity.Post;
import com.blog.blogrestapi.data.mapper.PostMapper;
import com.blog.blogrestapi.data.repository.PostRepository;
import com.blog.blogrestapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createPost(CreatePostRequestDto dto) {
        Post newPost = new Post();
        newPost.setTitle(dto.getTitle());
        newPost.setBody(dto.getBody());

        Post createPost = postRepository.save(newPost);

        return PostMapper.entityToDto(createPost);
    }

}
