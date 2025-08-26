package com.mindconnect.socialmedia.PostService.repository;

import com.mindconnect.socialmedia.PostService.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
}
