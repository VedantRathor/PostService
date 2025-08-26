package com.mindconnect.socialmedia.PostService.controller;

import com.mindconnect.socialmedia.PostService.common.ApiResponse;
import com.mindconnect.socialmedia.PostService.dto.*;
import com.mindconnect.socialmedia.PostService.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    // Bean creation using Contructor Injection
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // To get post details, postId is mandatory
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<GetPostResponseDTO>> getPostDetailsByPostId(@PathVariable("postId") @NotBlank(message = "PostId must be valid") String postId) {
        GetPostResponseDTO responseDTO = postService.getPostDetailsByPostId(postId);
        return ResponseEntity.ok(new ApiResponse<>(true, responseDTO, "Post retrieved successfully"));
    }

    // To create a post
    @PostMapping
    public ResponseEntity<ApiResponse<CreatePostResponseDTO>> createPost(@Valid @RequestBody CreatePostRequestDTO requestDTO) {
        CreatePostResponseDTO responseDTO = postService.createPost(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, responseDTO, "Post created."));
    }

    // To get all the posts of a particular user
    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<GetAllPostResponseDTO>> getAllPostByUserId(@PathVariable("userId") String userId) {
        GetAllPostResponseDTO responseDTO = postService.getAllPostByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<GetAllPostResponseDTO>(true, responseDTO, "All posts are retrieved successfully"));
    }

    // To update a post
    @PutMapping("/{postId}")
    public ResponseEntity<ApiResponse<UpdatePostResponseDTO>> updatePostByPostId(@PathVariable("postId") @NotBlank(message = "PostId must not be blank") String postId, @Valid @RequestBody UpdatePostRequestDTO requestDTO) {
        UpdatePostResponseDTO responseDTO = postService.updatePostByPostId(postId, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, responseDTO, "Updation is done"));
    }

    // To delete a post
    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse<String>> deletePostByPostId(@PathVariable(value = "postId") @NotBlank(message = "PostId must not be blank") String postId) {
        postService.deletePostByPostId(postId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<String>(true, null, "Post deleted"));
    }
}
