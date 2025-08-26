package com.mindconnect.socialmedia.PostService.repository;

import com.mindconnect.socialmedia.PostService.entity.IdempotencyKeyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IdempotencyKeyRepository extends MongoRepository<IdempotencyKeyEntity, String> {
    Optional<IdempotencyKeyEntity> findByIdempotencyKey(String idempotencyKey);
}
