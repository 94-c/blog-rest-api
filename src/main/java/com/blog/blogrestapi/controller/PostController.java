package com.blog.blogrestapi.controller;

import com.blog.blogrestapi.data.dto.PostDto;
import com.blog.blogrestapi.data.dto.request.CreatePostRequestDto;
import com.blog.blogrestapi.data.dto.request.PostResponse;
import com.blog.blogrestapi.data.dto.request.PostSingleResponse;
import com.blog.blogrestapi.data.entity.Post;
import com.blog.blogrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public PostResponse postList(){
        List<PostDto> postDtoList = postService.getPosts();
        PostResponse postResponse = new PostResponse();
        postResponse.setPostDtoList(postDtoList);

        return postResponse;
    }

    @PostMapping()
    public ResponseEntity<PostSingleResponse> createPost(@RequestBody CreatePostRequestDto dto) {
        PostDto postDto = postService.createPost(dto);
        PostSingleResponse response = new PostSingleResponse();
        response.setDto(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
