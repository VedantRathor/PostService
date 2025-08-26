package com.mindconnect.socialmedia.PostService.dto;

import java.util.List;

public class GetAllPostResponseDTO {
    private List<GetPostResponseDTO> activePosts;
    private List<GetPostResponseDTO> deletedPosts;
    private Integer activePostCounts;
    private Integer deletedPostCounts;

    public GetAllPostResponseDTO(List<GetPostResponseDTO> activePosts, List<GetPostResponseDTO> deletedPosts) {
        this.activePosts = activePosts;
        this.deletedPosts = deletedPosts;
        this.activePostCounts = activePosts.size();
        this.deletedPostCounts = deletedPosts.size();
    }

    public List<GetPostResponseDTO> getActivePosts() {
        return activePosts;
    }

    public List<GetPostResponseDTO> getDeletedPosts() {
        return deletedPosts;
    }

    public void setActivePosts(List<GetPostResponseDTO> activePosts) {
        this.activePosts = activePosts;
    }

    public void setDeletedPosts(List<GetPostResponseDTO> deletedPosts) {
        this.deletedPosts = deletedPosts;
    }

    public void addActivePost(GetPostResponseDTO activePost) {
        this.activePosts.add(activePost);
    }

    public Integer getActivePostCounts() {
        this.activePostCounts = activePosts.size();
        return this.activePostCounts;
    }

    public Integer getDeletedPostCounts() {
        deletedPostCounts = deletedPosts.size();
        return deletedPostCounts;
    }
}
