package com.mindconnect.socialmedia.PostService.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class PostCreatedEvent {
    @NotBlank(message = "PostId must not be blank")
    private String postId;
    @NotBlank(message = "CreatorId must not be blank")
    private String creatorId;
    @NotNull(message = "PostCreatedAt must not be null")
    private Instant postCreatedAt;

    public PostCreatedEvent() {}

    public PostCreatedEvent(String postId, String creatorId, Instant postCreatedAt) {
        this.postId = postId;
        this.creatorId = creatorId;
        this.postCreatedAt = postCreatedAt;
    }

    public Instant getPostCreatedAt() {
        return postCreatedAt;
    }

    public void setPostCreatedAt(Instant postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
