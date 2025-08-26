package com.mindconnect.socialmedia.PostService.dto;

import java.time.Instant;

public class UpdatePostResponseDTO {
    private String userId;
    private String postId;
    private Instant updatedAt;

    public UpdatePostResponseDTO() {}

    public UpdatePostResponseDTO(String userId, String postId, Instant updatedAt) {
        this.userId = userId;
        this.postId = postId;
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
