package com.mindconnect.socialmedia.PostService.repository;

import com.mindconnect.socialmedia.PostService.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findAllPostsByUserId(String userId);

    @Query("{ 'postId': ?0, 'deletedAt': null}")
    Optional<PostEntity> findByPostIdAndDeleteAtIsNull(String postId);
}
