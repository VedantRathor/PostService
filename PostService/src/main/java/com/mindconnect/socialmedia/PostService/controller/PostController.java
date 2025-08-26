package com.mindconnect.socialmedia.PostService.controller;

import com.mindconnect.socialmedia.PostService.dtos.CreatePostRequestDTO;
import com.mindconnect.socialmedia.PostService.dtos.CreatePostResponseDTO;
import com.mindconnect.socialmedia.PostService.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostDetailsByPostId(@PathVariable(value = "postId") Long postId) {
        return ResponseEntity.status(HttpStatus.OK).body("My Vedant: " + postId);
    }

    @PostMapping
    public ResponseEntity<CreatePostResponseDTO> createPost(@Valid @RequestBody CreatePostRequestDTO requestDTO) {
        CreatePostResponseDTO responseDTO = postService.createPost(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
