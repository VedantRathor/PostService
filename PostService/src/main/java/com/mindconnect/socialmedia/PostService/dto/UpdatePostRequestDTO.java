package com.mindconnect.socialmedia.PostService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UpdatePostRequestDTO {
    @NotBlank(message = "UserId is mandatory")
    private String userId;
    private String email;
    @Size(max = 5, message = "At max 5 attachments are possible")
    private List<String> attachments;
    @NotBlank(message = "Content is mandatory")
    private String content;

    public UpdatePostRequestDTO() {}

    public UpdatePostRequestDTO(String userId, String email, List<String> attachments, String content) {
        this.userId = userId;
        this.email = email;
        this.attachments = attachments;
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
