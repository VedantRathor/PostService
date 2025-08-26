package com.mindconnect.socialmedia.PostService.dtos;

import java.time.Instant;

public class CreatePostResponseDTO {
    private String postId;
    private Instant createdAt;
    private Instant updatedAt;

    public CreatePostResponseDTO() {}
    public CreatePostResponseDTO(String postId, Instant createdAt, Instant updatedAt) {
        this.postId = postId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
