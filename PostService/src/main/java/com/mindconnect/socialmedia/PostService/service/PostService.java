package com.mindconnect.socialmedia.PostService.service;

import com.mindconnect.socialmedia.PostService.dtos.CreatePostRequestDTO;
import com.mindconnect.socialmedia.PostService.dtos.CreatePostResponseDTO;
import com.mindconnect.socialmedia.PostService.mapper.PostMapper;
import com.mindconnect.socialmedia.PostService.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public CreatePostResponseDTO createPost(CreatePostRequestDTO requestDTO) {
        return PostMapper.toResponseDTO(postRepository.save(PostMapper.toEntity(requestDTO)));
    }
}
