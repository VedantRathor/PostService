package com.mindconnect.socialmedia.PostService.repository;

import com.mindconnect.socialmedia.PostService.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findAllPostsByUserId(String userId);
}
