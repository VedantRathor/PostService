package com.mindconnect.socialmedia.PostService.mapper;

import com.mindconnect.socialmedia.PostService.dto.*;
import com.mindconnect.socialmedia.PostService.entity.PostEntity;

public class PostServiceMapper {
    public static PostEntity toEntity(CreatePostRequestDTO requestDTO) {
        return new PostEntity(requestDTO.getUserId(), requestDTO.getContent(), requestDTO.getAttachments(), requestDTO.getUserId());
    }

    public static PostEntity toEntity(UpdatePostRequestDTO requestDTO) {
        return new PostEntity(requestDTO.getUserId(), requestDTO.getContent(), requestDTO.getAttachments(), requestDTO.getUserId());
    }

    public static CreatePostResponseDTO toResponseDTO(PostEntity postEntity) {
        return new CreatePostResponseDTO(postEntity.getPostId(), postEntity.getCreatedAt(), postEntity.getUpdatedAt());
    }

    public static UpdatePostResponseDTO toUpdatePostResponseDTO(PostEntity postEntity) {
        return new UpdatePostResponseDTO(
                postEntity.getUserId(),
                postEntity.getPostId(),
                postEntity.getUpdatedAt()
        );
    }

    public static GetPostResponseDTO toGetPostResponseDTO(PostEntity postEntity) {
        return new GetPostResponseDTO(
                postEntity.getPostId(),
                postEntity.getContent(),
                postEntity.getAttachments(),
                postEntity.getUserId(),
                postEntity.getCreatedAt(),
                postEntity.getUpdatedAt(),
                postEntity.getUpdatedBy()
        );
    }
}
