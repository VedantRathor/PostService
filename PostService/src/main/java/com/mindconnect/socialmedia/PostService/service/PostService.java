package com.mindconnect.socialmedia.PostService.service;

import com.mindconnect.socialmedia.PostService.dto.*;
import com.mindconnect.socialmedia.PostService.entity.PostEntity;
import com.mindconnect.socialmedia.PostService.mapper.PostServiceMapper;
import com.mindconnect.socialmedia.PostService.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CreatePostResponseDTO createPost(CreatePostRequestDTO requestDTO) {
        return PostServiceMapper.toResponseDTO(postRepository.save(PostServiceMapper.toEntity(requestDTO)));
    }

    public GetPostResponseDTO getPostDetailsByPostId(String postId) {
        PostEntity postEntity = postRepository.findById(postId).orElse(null);

        if (postEntity == null) return null;
        return PostServiceMapper.toGetPostResponseDTO(postEntity);
    }

    public GetAllPostResponseDTO getAllPostByUserId(String userId) {
        List<PostEntity> postEntities = postRepository.findAllPostsByUserId(userId);
        List<GetPostResponseDTO> getPostResponseDTOList = new ArrayList<>();

        if (postEntities != null && !postEntities.isEmpty()) {
            for (PostEntity postEntity: postEntities) {
                getPostResponseDTOList.add(PostServiceMapper.toGetPostResponseDTO(postEntity));
            }
        }

        return new GetAllPostResponseDTO(getPostResponseDTOList);
    }

    public CreatePostResponseDTO updatePostByPostId(String postId, UpdatePostRequestDTO requestDTO) {
        PostEntity post = postRepository.findById(postId).orElse(null);
        if (post == null) return null;

        post.setContent(requestDTO.getContent());
        post.setAttachments(requestDTO.getAttachments());
        post.setUpdatedBy(requestDTO.getUserId());

        PostEntity savedPost = postRepository.save(post);

        return PostServiceMapper.toResponseDTO(savedPost);
    }
}
