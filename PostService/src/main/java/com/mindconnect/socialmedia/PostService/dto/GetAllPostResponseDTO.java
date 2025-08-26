package com.mindconnect.socialmedia.PostService.dto;

import java.util.List;

public class GetAllPostResponseDTO {
    private List<GetPostResponseDTO> posts;
    private Integer postCounts;

    public GetAllPostResponseDTO(List<GetPostResponseDTO> posts) {
        this.posts = posts;
        this.postCounts = posts.size();
    }

    public List<GetPostResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<GetPostResponseDTO> posts) {
        this.posts = posts;
    }

    public void addPost(GetPostResponseDTO post) {
        this.posts.add(post);
    }

    public Integer getPostCounts() {
        this.postCounts = posts.size();
        return this.postCounts;
    }
}
