package com.mindconnect.socialmedia.PostService.entity;

import com.mindconnect.socialmedia.PostService.common.IdempotencyStatus;
import com.mindconnect.socialmedia.PostService.dto.CreatePostResponseDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "idempotentKeys")
public class IdempotencyKeyEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String idempotencyKey;
    @CreatedDate
    @Indexed(name = "ttl_index", expireAfter = "PT5M")
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    private IdempotencyStatus idempotencyStatus;
    private CreatePostResponseDTO response;

    public IdempotencyKeyEntity(String idempotencyKey, IdempotencyStatus idempotencyStatus) {
        this.idempotencyKey = idempotencyKey;
        this.idempotencyStatus = idempotencyStatus;
        this.response = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public IdempotencyStatus getIdempotencyStatus() {
        return idempotencyStatus;
    }

    public void setIdempotencyStatus(IdempotencyStatus idempotencyStatus) {
        this.idempotencyStatus = idempotencyStatus;
    }

    public CreatePostResponseDTO getResponse() {
        return response;
    }

    public void setResponse(CreatePostResponseDTO response) {
        this.response = response;
    }
}
