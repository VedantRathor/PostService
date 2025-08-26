package com.mindconnect.socialmedia.PostService.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

public class GetPostResponseDTO {
    @NotBlank(message = "PostId is needed")
    private String postId;
    @NotBlank(message = "Content cannot be empty")
    private String content;
    private List<String> attachments;
    @NotBlank(message = "CreatorId cannot be null or empty")
    private String creatorId;
    private Instant createdAt;
    private Instant updatedAt;
    @NotBlank(message = "UpdatedBy cannot be null or empty")
    private String updatedBy;

    public GetPostResponseDTO(String postId, String content, List<String> attachments, String creatorId, Instant createdAt, Instant updatedAt, String updatedBy) {
        this.postId = postId;
        this.content = content;
        this.attachments = attachments;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
