package com.blog.blogrestapi.service.impl;

import com.blog.blogrestapi.data.dto.CommentDto;
import com.blog.blogrestapi.data.entity.Comment;
import com.blog.blogrestapi.data.entity.Post;
import com.blog.blogrestapi.data.repository.CommentRepository;
import com.blog.blogrestapi.data.repository.PostRepository;
import com.blog.blogrestapi.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);
        Comment newComment =  commentRepository.save(comment);
        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if(!comment.getPost().getId().equals(post.getId())){
            System.out.println("Error");
        }

        return mapToDTO(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, long commentId, CommentDto dto) {
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if(!comment.getPost().getId().equals(post.getId())){
            System.out.println("Error");
        }

        comment.setBody(dto.getBody());

        Comment updatedComment = commentRepository.save(comment);
        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = commentRepository.findById(commentId).orElseThrow();

        if(!comment.getPost().getId().equals(post.getId())){
            System.out.println("Error");
        }

        commentRepository.delete(comment);
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = mapper.map(comment, CommentDto.class);
        return  commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = mapper.map(commentDto, Comment.class);
        return  comment;
    }
}
