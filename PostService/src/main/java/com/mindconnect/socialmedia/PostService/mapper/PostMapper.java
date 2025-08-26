package com.mindconnect.socialmedia.PostService.mapper;

import com.mindconnect.socialmedia.PostService.dtos.CreatePostRequestDTO;
import com.mindconnect.socialmedia.PostService.dtos.CreatePostResponseDTO;
import com.mindconnect.socialmedia.PostService.entity.PostEntity;

public class PostMapper {
    public static PostEntity toEntity(CreatePostRequestDTO requestDTO) {
        return new PostEntity(requestDTO.getUserId(), requestDTO.getContent(), requestDTO.getAttachments(), requestDTO.getUserId());
    }

    public static CreatePostResponseDTO toResponseDTO(PostEntity postEntity) {
        return new CreatePostResponseDTO(postEntity.getPostId(), postEntity.getCreatedAt(), postEntity.getUpdatedAt());
    }
}
