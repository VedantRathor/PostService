package com.mindconnect.socialmedia.PostService.controller;

import com.mindconnect.socialmedia.PostService.common.ApiResponse;
import com.mindconnect.socialmedia.PostService.dto.*;
import com.mindconnect.socialmedia.PostService.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    // Bean creation using Contructor Injection
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // To get post details, postId is mandatory
    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse<GetPostResponseDTO>> getPostDetailsByPostId(@PathVariable String postId) {
        GetPostResponseDTO responseDTO = postService.getPostDetailsByPostId(postId);

        if (responseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, null, "Post not found"));
        }

        return ResponseEntity.ok(new ApiResponse<>(true, responseDTO, "Post retrieved successfully"));
    }

    // To create a post
    @PostMapping
    public ResponseEntity<CreatePostResponseDTO> createPost(@Valid @RequestBody CreatePostRequestDTO requestDTO) {
        CreatePostResponseDTO responseDTO = postService.createPost(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // To get all the posts of a particular user
    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<GetAllPostResponseDTO>> getAllPostByUserId(@PathVariable("userId") String userId) {
        GetAllPostResponseDTO responseDTO = postService.getAllPostByUserId(userId);

        if (responseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<GetAllPostResponseDTO>(false, null, "This user has no posts"));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<GetAllPostResponseDTO>(
                        true,
                        responseDTO,
                        "All posts are retrieved successfully"
                ));
    }

    // To update a post
    @PutMapping("/{postId}")
    public ResponseEntity<ApiResponse<UpdatePostResponseDTO>> updatePostByPostId(@PathVariable("postId") String postId, @RequestBody UpdatePostRequestDTO requestDTO) {
        if (postId.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, null, "Post Id is empty"));
        }

        UpdatePostResponseDTO responseDTO = postService.updatePostByPostId(postId, requestDTO);

        if (responseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, null, "Post Id doesn't exist or some error occured"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, responseDTO, "Updation is done"));
    }
}
